package br.com.serratec.lojaserratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.lojaserratec.model.Cliente;
import br.com.serratec.lojaserratec.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository _repositorioCliente;
	
	@GetMapping
	public List<Cliente> obter(){
		return this._repositorioCliente.findAll();
		
	}
	
	@PostMapping
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return this._repositorioCliente.save(cliente);
	}
	
	@PutMapping("/{id}")
	public Cliente atualizar(@PathVariable(value = "id") Long id, @RequestBody Cliente cliente) {
		cliente.setId(id);
		return this._repositorioCliente.save(cliente);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable(value = "id") Long id) {
		this._repositorioCliente.deleteById(id);
	}
	
}
