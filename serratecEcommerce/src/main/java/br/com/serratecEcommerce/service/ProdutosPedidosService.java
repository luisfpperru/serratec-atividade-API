package br.com.serratecEcommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratecEcommerce.model.ProdutosPedidos;
import br.com.serratecEcommerce.repository.ProdutosPedidosRepository;


@Service
public class ProdutosPedidosService {

		@Autowired
		private ProdutosPedidosRepository _serviceProdutosPedidos;
		
		public List<ProdutosPedidos> obterTodos(){
			return this._serviceProdutosPedidos.findAll();
			}
		
		public ProdutosPedidos adicionar(ProdutosPedidos produtos) {
			produtos.setId(null);
			//Poderia validar se os campos obrigatorios foram preenchidos
				return this._serviceProdutosPedidos.save(produtos);
	
		}
}
