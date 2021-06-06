package br.com.serratecEcommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratecEcommerce.model.Produto;
import br.com.serratecEcommerce.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@Api(value = "API REST Serratec E-Commerce - PRODUTO")
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoService _servicoProduto;
	
	@ApiOperation(value = "Retorna uma lista com todos os produtos")
	@GetMapping
	public List<Produto> obterTodos(){
		return _servicoProduto.obterTodos();
	}

	@ApiOperation(value = "Retorna um produto pelo ID")
	@GetMapping("/{id}")
	public Optional<Produto> obterPorId(@PathVariable(value = "id") Long id){
		return _servicoProduto.obterPorId(id);
	}
	
	@ApiOperation(value = "Adiciona um produto")
	@PostMapping
	public ResponseEntity<Produto> adicionar(@RequestBody Produto produto){
        return _servicoProduto.adicionar(produto);
	}
	
	@ApiOperation(value = "Atualiza um produto existente")
	@PutMapping("/id/{id}")
	 public Produto atualizar(@PathVariable(value = "id") Long id, @RequestBody Produto produto) {
         return _servicoProduto.atualizar(id, produto);
	 }

	 @ApiOperation(value = "Deleta um produto existente")
	 @DeleteMapping("/id/{id}")
	 public void deletar(@PathVariable(value = "id") Long id) {
		_servicoProduto.deletar(id);
	 }
}
