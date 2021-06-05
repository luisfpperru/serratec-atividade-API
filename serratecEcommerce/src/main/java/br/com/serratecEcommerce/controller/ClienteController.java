package br.com.serratecEcommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratecEcommerce.model.Cliente;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@GetMapping
	public List<Cliente> obterTodos(){
		return obterTodos();
	}

	@GetMapping("/id/{id}")
	public Optional<Cliente> obterPorId(@PathVariable(value = "id") Long id){
		return obterPorId(id);
	}
	
	@GetMapping("/nome/{nome}")
	public List<Cliente> obterPorNome(@PathVariable(value = "nome") String nome){
		return obterPorNome(nome);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> adicionar(@RequestBody Cliente cliente){
        return adicionar(cliente);
	}
	
	@PutMapping
	 public Cliente atualizar(@PathVariable(value = "id") Long id, @RequestBody Cliente cliente) {
         return atualizar(id, cliente);
	 }

	 @DeleteMapping("/id/{id}")
	 public void deletar(@PathVariable(value = "id") Long id) {
			deletar(id);
	 }
}
