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

import br.com.serratecEcommerce.model.ProdutosPedidos;
import br.com.serratecEcommerce.service.ProdutosPedidosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@Api(value = "API REST Serratec E-Commerce - PRODUTOS PEDIDOS")
@RestController
@RequestMapping("/api/produtosPedidos")
public class ProdutosPedidosController {
	
	@Autowired
	ProdutosPedidosService _servicoProdutosPedidos;
	
	@ApiOperation(value = "Retorna uma lista dos produtos pedidos")
	@GetMapping
	public List<ProdutosPedidos> obterTodos(){
		return _servicoProdutosPedidos.obterTodos();
	}

	@ApiOperation(value = "Retorna um produto pedido pelo ID")
	@GetMapping("/{id}")
	public Optional<ProdutosPedidos> obterPorId(@PathVariable(value = "id") Long id){
		return _servicoProdutosPedidos.obterPorId(id);
	}
	
	@ApiOperation(value = "Adiciona um produto a um pedido")
	@PostMapping
	public ResponseEntity<ProdutosPedidos> adicionar(@RequestBody ProdutosPedidos produtosPedidos){
        return _servicoProdutosPedidos.adicionar(produtosPedidos);
	}
	
	@ApiOperation(value = "Atualiza um produto de um pedido")
	@PutMapping("/id/{id}")
	 public ProdutosPedidos atualizar(@PathVariable(value = "id") Long id, @RequestBody ProdutosPedidos produtosPedidos) {
         return _servicoProdutosPedidos.atualizar(id,produtosPedidos);
	 }

	 @ApiOperation(value = "Retira um produto de um pedido")
	 @DeleteMapping("/id/{id}")
	 public void deletar(@PathVariable(value = "id") Long id) {
		_servicoProdutosPedidos.deletar(id);
	 }
}
