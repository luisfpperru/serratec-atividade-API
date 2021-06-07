package br.com.serratecEcommerce.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratecEcommerce.model.Pedidos;
import br.com.serratecEcommerce.model.exception.ResourceNotFoundException;
import br.com.serratecEcommerce.repository.PedidosRepository;

@Service
public class PedidosService {
	@Autowired
	private PedidosRepository _repositorioPedidos;
	
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
 		_repositorioPedidos.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Pedido não encontrado(a) pelo ID:" + id));
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
