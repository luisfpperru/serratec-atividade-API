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

import br.com.serratecEcommerce.model.Cliente;
import br.com.serratecEcommerce.repository.ClienteRepository;




@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	ClienteRepository _repositorioCliente;
	
	@GetMapping
	public List<Cliente> obterTodos(){
		return this._repositorioCliente.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Cliente> obterPorId(@PathVariable(value = "id") Long id){
		return this._repositorioCliente.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Cliente>  adicionar(@RequestBody Cliente cliente){
		var adicionado = this._repositorioCliente.save(cliente);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
	}
	
	 public Cliente atualizar(@PathVariable(value = "id") Long id, @RequestBody Cliente cliente) {
 		_repositorioCliente.findById(id);
 						 //.orElseThrow( ()-> new NotFoundException("Cliente não encontrado(a) pelo ID:" + id));
 		 cliente.setId(id);
         return this._repositorioCliente.save(cliente);
	 }

	 @DeleteMapping("/id/{id}")
	 public void deletar(@PathVariable(value = "id") Long id) {
			_repositorioCliente.findById(id);
							 //.orElseThrow( ()-> new NotFoundException("Cliente não encontrado(a) pelo ID:" + id));
         this._repositorioCliente.deleteById(id);
	 }
}
