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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratecEcommerce.model.ProdutosPedidos;
import br.com.serratecEcommerce.repository.ProdutosPedidosRepository;

@RestController
@RequestMapping("/api/produtosPedidos")
public class ProdutosPedidosController {
	@Autowired
	ProdutosPedidosRepository _repositorioProdutosPedidos;
	
	@GetMapping
	public List<ProdutosPedidos> obterTodos(){
		return this._repositorioProdutosPedidos.findAll();
	}

	@GetMapping("/{id}")
	public Optional<ProdutosPedidos> obterPorId(@PathVariable(value = "id") Long id){
		return this._repositorioProdutosPedidos.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<ProdutosPedidos> adicionar(@RequestBody ProdutosPedidos produtosPedidos){
		var adicionado = this._repositorioProdutosPedidos.save(produtosPedidos);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
	}
	
	 public ProdutosPedidos atualizar(@PathVariable(value = "id") Long id, @RequestBody ProdutosPedidos produtosPedidos) {
 		_repositorioProdutosPedidos.findById(id);
 						 //.orElseThrow( ()-> new NotFoundException("Categoria não encontrada pelo ID:" + id));
 		produtosPedidos.setId(id);
         return this._repositorioProdutosPedidos.save(produtosPedidos);
	 }

	 @DeleteMapping("/id/{id}")
	 public void deletar(@PathVariable(value = "id") Long id) {
			_repositorioProdutosPedidos.findById(id);
							 //.orElseThrow( ()-> new NotFoundException("Categoria não encontrada pelo ID:" + id));
         this._repositorioProdutosPedidos.deleteById(id);
	 }
}
