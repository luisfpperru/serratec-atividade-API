package br.com.serratecEcommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratecEcommerce.model.Produto;
import br.com.serratecEcommerce.repository.ProdutoRepository;


@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository _repositorioProduto;
	
	public List<Produto> obterTodos(){
		return this._repositorioProduto.findAll();
		}
	
	public Optional<Produto> obterPorId(Long id){
		return this._repositorioProduto.findById(id);
	}
	
	public ResponseEntity<Produto> adicionar(Produto produto){
		produto.setId(null);
		var adicionado = this._repositorioProduto.save(produto);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
	}
	
	 public Produto atualizar(Long id,Produto produto) {
 		_repositorioProduto.findById(id);
 						 //.orElseThrow( ()-> new NotFoundException("Categoria não encontrada pelo ID:" + id));
 		 produto.setId(id);
         return this._repositorioProduto.save(produto);
	 }

	 public void deletar(Long id) {
			_repositorioProduto.findById(id);
							 //.orElseThrow( ()-> new NotFoundException("Categoria não encontrada pelo ID:" + id));
         this._repositorioProduto.deleteById(id);
	 }
}
