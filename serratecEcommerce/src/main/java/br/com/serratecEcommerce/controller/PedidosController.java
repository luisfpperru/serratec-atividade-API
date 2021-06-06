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

import br.com.serratecEcommerce.model.Pedidos;
import br.com.serratecEcommerce.service.PedidosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@Api(value = "API REST Serratec E-Commerce - PEDIDOS")
@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {
	
	@Autowired
	PedidosService _servicoPedidos;
	
	@ApiOperation(value = "Retorna uma lista com todos os pedidos")
	@GetMapping
	public List<Pedidos> obterTodos(){
		return _servicoPedidos.obterTodos();
	}

	@ApiOperation(value = "Retorna um pedido pelo ID")
	@GetMapping("/{id}")
	public Optional<Pedidos> obterPorId(@PathVariable(value = "id") Long id){
		return _servicoPedidos.obterPorId(id);
	}
	
	@ApiOperation(value = "Adiciona um pedido")
	@PostMapping
	public ResponseEntity<Pedidos>  adicionar(@RequestBody Pedidos pedidos){
        return _servicoPedidos.adicionar(pedidos);
	}
	
	@ApiOperation(value = "Atualiza um pedido existente")
	@PutMapping("/id/{id}")
	 public Pedidos atualizar(@PathVariable(value = "id") Long id, @RequestBody Pedidos pedidos) {
         return _servicoPedidos.atualizar(id,pedidos);
	 }

	 @ApiOperation(value = "Deleta um pedido existente")
	 @DeleteMapping("/id/{id}")
	 public void deletar(@PathVariable(value = "id") Long id) {
		_servicoPedidos.deletar(id);
	 }
}
