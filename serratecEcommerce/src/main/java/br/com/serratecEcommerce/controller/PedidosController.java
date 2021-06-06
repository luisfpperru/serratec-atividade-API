package br.com.serratecEcommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratecEcommerce.model.Pedidos;
import br.com.serratecEcommerce.repository.PedidosRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@Api(value = "API REST Serratec E-Commerce - PEDIDOS")
@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {
	
	@ApiOperation(value = "Retorna uma lista com todos os pedidos")
	@GetMapping
	public List<Pedidos> obterTodos(){
		return obterTodos();
	}

	@ApiOperation(value = "Retorna um pedido pelo ID")
	@GetMapping("/{id}")
	public Optional<Pedidos> obterPorId(@PathVariable(value = "id") Long id){
		return obterPorId(id);
	}
	
	@ApiOperation(value = "Adiciona um pedido")
	@PostMapping
	public ResponseEntity<Pedidos>  adicionar(@RequestBody Pedidos pedidos){
        return adicionar(pedidos);
	}
	
	@ApiOperation(value = "Atualiza um pedido existente")
	 public Pedidos atualizar(@PathVariable(value = "id") Long id, @RequestBody Pedidos pedidos) {
         return atualizar(id,pedidos);
	 }

	@ApiOperation(value = "Deleta um pedido existente")
	 @DeleteMapping("/id/{id}")
	 public void deletar(@PathVariable(value = "id") Long id) {
         deletar(id);
	 }
}
