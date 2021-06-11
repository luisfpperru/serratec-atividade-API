package br.com.serratecEcommerce.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratecEcommerce.model.Pedido;
import br.com.serratecEcommerce.model.email.MensagemEmail;
import br.com.serratecEcommerce.model.exception.ResourceBadRequestException;
import br.com.serratecEcommerce.model.exception.ResourceNotFoundException;
import br.com.serratecEcommerce.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository _repositorioPedidos;
	
	@Autowired 
	private EmailService _serviceEmail;
	
	public List<Pedido> obterTodos(){
		return this._repositorioPedidos.findAll();
	}
	
	public Optional<Pedido> obterPorId(Long id){
		return this._repositorioPedidos.findById(id);
	}
	
	public ResponseEntity<Pedido> adicionar(Pedido pedidos){
		pedidos.setId(null);
		//pedidos.setValorTotalDoPedido(this.calcularValorTotal(pedidos));
		pedidos.setDataDoPedido(new Date());
		var adicionado = this._repositorioPedidos.save(pedidos);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
	}
	
	 public Pedido atualizar(Long id, Pedido pedidos) {
 		var pedidosAtual = _repositorioPedidos.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Pedido não encontrado(a) pelo ID:" + id));
 		if (pedidosAtual.getStatus().equals("finalizado") || pedidos.getStatus().equals("Finalizado")) {
 			throw new ResourceBadRequestException("O usuário está tentando modificar um pedido já finalizado.");
		 }
 		if (pedidos.getStatus().equals("finalizado") || pedidos.getStatus().equals("Finalizado")) {
 			var destinatarios = new ArrayList<String>();
 			destinatarios.add("serratecdev@gmail.com");
 			destinatarios.add(pedidos.getCliente().getEmail());
 			var email  = new MensagemEmail("Sua compra foi finalizada com sucesso!",
 										   "Data de entrega: "+ calculaDataDeEntrega()+", Seu carrinho: XXXX, Valor Total da sua compra: " + pedidos.getValorTotalDoPedido(),
 										   "Serratec Ecommerce <serratecdev@gmail.com>",
 										   destinatarios);
 			_serviceEmail.enviarEmail(email);
 		}
 		pedidos.setId(id); 			 
 		return this._repositorioPedidos.save(pedidos);
	 }

	 public void deletar(Long id) {
			_repositorioPedidos.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Pedido não encontrado(a) pelo ID:" + id));
         this._repositorioPedidos.deleteById(id);
	 }
	 /*
	 private double calcularValorTotal(Pedidos pedidos) {
		 return 0.0;
	 }
	 */
	 private Date calculaDataDeEntrega() {
		 return new Date(new Date().getTime() + 5*24*3600*1000);
	 }
}
