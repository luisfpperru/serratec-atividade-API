package br.com.serratecEcommerce.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratecEcommerce.model.Pedidos;
import br.com.serratecEcommerce.model.email.MensagemEmail;
import br.com.serratecEcommerce.model.exception.ResourceBadRequestException;
import br.com.serratecEcommerce.model.exception.ResourceNotFoundException;
import br.com.serratecEcommerce.repository.PedidosRepository;

@Service
public class PedidosService {
	
	@Autowired
	private PedidosRepository _repositorioPedidos;
	
	@Autowired 
	private EmailService _serviceEmail;
	
	public List<Pedidos> obterTodos(){
		return this._repositorioPedidos.findAll();
	}
	
	public Optional<Pedidos> obterPorId(Long id){
		return this._repositorioPedidos.findById(id);
	}
	
	public ResponseEntity<Pedidos> adicionar(Pedidos pedidos){
		pedidos.setId(null);
		//pedidos.setValorTotalDoPedido(this.calcularValorTotal(pedidos));
		pedidos.setDataDoPedido(new Date());
		var adicionado = this._repositorioPedidos.save(pedidos);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
	}
	
	 public Pedidos atualizar(Long id, Pedidos pedidos) {
 		var pedidosAtual = _repositorioPedidos.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Pedido não encontrado(a) pelo ID:" + id));
 		if (pedidosAtual.getStatus() == "finalizado" || pedidos.getStatus() == "Finalizado") {
 			throw new ResourceBadRequestException("O usuário está tentando modificar um pedido já finalizado.");
		 }
 		if (pedidos.getStatus() == "finalizado" || pedidos.getStatus() == "Finalizado") {
 			var destinatarios = new ArrayList<String>();
 			destinatarios.add("serratecdev@gmail.com");
 			destinatarios.add("emaildocliente");
 			var email  = new MensagemEmail("Sua compra foi finalizada com sucesso!",
 										   "Data de entrega: dd-mm-AAAA, Seu carrinho: XXXX, Valor Total da sua compra: " + pedidos.getValorTotalDoPedido(),
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
}
