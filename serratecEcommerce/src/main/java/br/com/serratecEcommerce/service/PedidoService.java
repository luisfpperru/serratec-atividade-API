package br.com.serratecEcommerce.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratecEcommerce.model.Cliente;
import br.com.serratecEcommerce.model.Pedido;
import br.com.serratecEcommerce.model.Produto;
import br.com.serratecEcommerce.model.email.MensagemEmail;
import br.com.serratecEcommerce.model.exception.ResourceBadRequestException;
import br.com.serratecEcommerce.model.exception.ResourceNotFoundException;
import br.com.serratecEcommerce.repository.ClienteRepository;
import br.com.serratecEcommerce.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository _repositorioPedido;
	
	@Autowired
	private ClienteRepository _repositorioCliente;
	
	@Autowired 
	private EmailService _serviceEmail;
	
	public List<Pedido> obterTodos(){
		return this._repositorioPedido.findAll();
	}
	
	public Optional<Pedido> obterPorId(Long id){
		return this._repositorioPedido.findById(id);
	}
	
	public ResponseEntity<Pedido> adicionar(Pedido pedido){
		pedido.setId(null);
		calcularValorTotal(pedido);
		pedido.setDataDoPedido(new Date());
		var adicionado = this._repositorioPedido.save(pedido);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
	}
	
	public ResponseEntity<Pedido> adicionarPedidoDoCliente(Pedido pedido,Long clienteId) {
		pedido.setId(null);
		Optional<Cliente> cliente = _repositorioCliente.findById(clienteId);
		if (cliente.isEmpty())
			throw new ResourceNotFoundException("Cliente não encontrada pelo ID:" + clienteId);
		pedido.setCliente(cliente.get());
		pedido.setDataDoPedido(new Date());
		calcularValorTotal(pedido);
		var adicionado = _repositorioPedido.save(pedido);
		checarPedidoFinalizado(pedido);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
	}
	
	 public Pedido atualizar(Long id, Pedido pedido) {
 		var pedidoAtual = _repositorioPedido.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Pedido não encontrado(a) pelo ID:" + id));
 		validarPedido(pedidoAtual);
		calcularValorTotal(pedido);
 		pedido.setId(id);
 		var atualizado = this._repositorioPedido.save(pedido);
 		checarPedidoFinalizado(pedido);
 		return atualizado;
	 }

	 public void deletar(Long id) {
			_repositorioPedido.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Pedido não encontrado(a) pelo ID:" + id));
         this._repositorioPedido.deleteById(id);
	 }
	 
	 private void calcularValorTotal(Pedido pedido) {
		 var valorTotal = 0.0;
		 for (Produto produto:pedido.getProdutos())
			 	valorTotal += produto.getPreco();					
		 pedido.setValorTotalDoPedido(valorTotal);
	 }
	private void validarPedido(Pedido pedido) {
		if (pedido.getStatus().equals("finalizado") || pedido.getStatus().equals("Finalizado")) {
 			throw new ResourceBadRequestException("O usuário está tentando modificar um pedido já finalizado.");
		 }
	}
	private void checarPedidoFinalizado(Pedido pedido) {
		if (pedido.getStatus().equals("finalizado") || pedido.getStatus().equals("Finalizado")) {
			var destinatarios = new ArrayList<String>();
			destinatarios.add("serratecdev@gmail.com");
			destinatarios.add(pedido.getCliente().getEmail());
			var email  = new MensagemEmail("Sua compra foi finalizada com sucesso!",
										   "Data de entrega: "+ calculaDataDeEntrega()+", Seu carrinho:"+exibirProdutosNoPedido(pedido)+", Valor Total da sua compra: " + pedido.getValorTotalDoPedido(),	   
										   "Serratec Ecommerce <serratecdev@gmail.com>",
										   destinatarios);
			_serviceEmail.enviarEmail(email);
		}
	}
	 private Date calculaDataDeEntrega() {
		 return new Date(new Date().getTime() + 5*24*3600*1000); // 5 dias * 24 horas * 3600 segundos * 1000 milisegundos
	 }
	 private String exibirProdutosNoPedido(Pedido pedido) {
		String lista = "";
        for( Produto produto: pedido.getProdutos())
        	lista += String.format("/n  %s  %s  %s  /n",produto.getNome(),produto.getPreco(),produto.getQuantidadeEmEstoque(),produto.getDescricao());
        return lista;
	 } 
}
