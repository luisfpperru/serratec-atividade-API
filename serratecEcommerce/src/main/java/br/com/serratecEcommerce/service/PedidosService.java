package br.com.serratecEcommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratecEcommerce.model.Pedidos;
import br.com.serratecEcommerce.repository.PedidosRepository;


@Service
public class PedidosService {
	@Autowired
	private PedidosRepository _repositorioPedidos;
	
	public List<Pedidos> obterTodos(){
		return this._repositorioPedidos.findAll();
		}
	
	public Pedidos adicionar(Pedidos pedidos) {
		pedidos.setId(null);
		//Poderia validar se os campos obrigatorios foram preenchidos
		return this._repositorioPedidos.save(pedidos);
	}
	
}
