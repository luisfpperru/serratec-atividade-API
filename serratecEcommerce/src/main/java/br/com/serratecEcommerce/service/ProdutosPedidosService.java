package br.com.serratecEcommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratecEcommerce.model.ProdutosPedidos;
import br.com.serratecEcommerce.model.exception.ResourceBadRequestException;
import br.com.serratecEcommerce.model.exception.ResourceNotFoundException;
import br.com.serratecEcommerce.repository.ProdutosPedidosRepository;

@Service
public class ProdutosPedidosService {

		@Autowired
		private ProdutosPedidosRepository _repositorioProdutosPedidos;
		
		public List<ProdutosPedidos> obterTodos(){
			return this._repositorioProdutosPedidos.findAll();
			}
		
		public Optional<ProdutosPedidos> obterPorId(Long id){
			return this._repositorioProdutosPedidos.findById(id);
		}
		
		public ResponseEntity<ProdutosPedidos> adicionar(ProdutosPedidos produtosPedidos){
			this.validarProdutosPedidos(produtosPedidos);
			produtosPedidos.setId(null);
			var adicionado = this._repositorioProdutosPedidos.save(produtosPedidos);
	        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
		}
		
		 public ProdutosPedidos atualizar(Long id,ProdutosPedidos produtosPedidos) {
	 		_repositorioProdutosPedidos.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Categoria não encontrada pelo ID:" + id));
	 		this.validarProdutosPedidos(produtosPedidos);
	 		produtosPedidos.setId(id);
	        return this._repositorioProdutosPedidos.save(produtosPedidos);
		 }

		 public void deletar(Long id) {
				_repositorioProdutosPedidos.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Categoria não encontrada pelo ID:" + id));
	         this._repositorioProdutosPedidos.deleteById(id);
		 }
		 
		 private void validarProdutosPedidos(ProdutosPedidos produtosPedidos) {
			 if (produtosPedidos.getQuantidade() < 0)
				 throw new ResourceBadRequestException("A quantidade desejada é negativa!");
			 if (produtosPedidos.getPreco() < 0)
				 throw new ResourceBadRequestException("O preço do produto é negativo!");
		 }
}
