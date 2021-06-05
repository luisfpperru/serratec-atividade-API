package br.com.serratecEcommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.serratecEcommerce.model.Produto;
import br.com.serratecEcommerce.repository.ProdutoRepository;

    public class ProdutoController {
	@Autowired
	ProdutoRepository _repositorioProduto;
	
	@GetMapping
	public List<Produto> obterTodos(){
		return this._repositorioProduto.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Produto> obterPorId(@PathVariable(value = "id") Long id){
		return this._repositorioProduto.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Produto> adicionar(@RequestBody Produto produto){
		var adicionado = this._repositorioProduto.save(produto);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
	}
	
	 public Produto atualizar(@PathVariable(value = "id") Long id, @RequestBody Produto produto) {
 		_repositorioProduto.findById(id);
 						 //.orElseThrow( ()-> new NotFoundException("Categoria não encontrada pelo ID:" + id));
 		 produto.setId(id);
         return this._repositorioProduto.save(produto);
	 }

	 @DeleteMapping("/id/{id}")
	 public void deletar(@PathVariable(value = "id") Long id) {
			_repositorioProduto.findById(id);
							 //.orElseThrow( ()-> new NotFoundException("Categoria não encontrada pelo ID:" + id));
         this._repositorioProduto.deleteById(id);
	 }
}
