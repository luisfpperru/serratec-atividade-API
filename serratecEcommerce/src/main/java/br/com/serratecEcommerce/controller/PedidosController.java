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
	
	@Autowired
	PedidosRepository _repositorioPedidos;
	
	@ApiOperation(value = "Retorna uma lista com todos os pedidos")
	@GetMapping
	public List<Pedidos> obterTodos(){
		return this._repositorioPedidos.findAll();
	}

	@ApiOperation(value = "Retorna um pedido pelo ID")
	@GetMapping("/{id}")
	public Optional<Pedidos> obterPorId(@PathVariable(value = "id") Long id){
		return this._repositorioPedidos.findById(id);
	}
	
	@ApiOperation(value = "Adiciona um pedido")
	@PostMapping
	public ResponseEntity<Pedidos>  adicionar(@RequestBody Pedidos pedidos){
		var adicionado = this._repositorioPedidos.save(pedidos);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Atualiza um pedido existente")
	 public Pedidos atualizar(@PathVariable(value = "id") Long id, @RequestBody Pedidos pedidos) {
 		_repositorioPedidos.findById(id);
 						 //.orElseThrow( ()-> new NotFoundException("Pedido não encontrado(a) pelo ID:" + id));
 		 pedidos.setId(id);
         return this._repositorioPedidos.save(pedidos);
	 }

	@ApiOperation(value = "Deleta um pedido existente")
	 @DeleteMapping("/id/{id}")
	 public void deletar(@PathVariable(value = "id") Long id) {
			_repositorioPedidos.findById(id);
							 //.orElseThrow( ()-> new NotFoundException("Pedido não encontrado(a) pelo ID:" + id));
         this._repositorioPedidos.deleteById(id);
	 }
}
