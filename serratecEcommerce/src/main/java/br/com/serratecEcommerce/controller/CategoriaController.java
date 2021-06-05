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

import br.com.serratecEcommerce.model.Categoria;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
	
	@GetMapping
	public List<Categoria> obterTodos(){
		return obterTodos();
	}

	@GetMapping("/id/{id}")
	public Optional<Categoria> obterPorId(@PathVariable(value = "id") Long id){
		return obterPorId(id);
	}
	
	@GetMapping("/nome/{nome}")
	public List<Categoria> obterPorNome(@PathVariable(value = "nome") String nome){
		return obterPorNome(nome);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> adicionar(@RequestBody Categoria categoria){
        return adicionar(categoria);
	}
	
	@PutMapping
	 public Categoria atualizar(@PathVariable(value = "id") Long id, @RequestBody Categoria categoria) {
         return atualizar(id, categoria);
	 }

	 @DeleteMapping("/id/{id}")
	 public void deletar(@PathVariable(value = "id") Long id) {
			deletar(id);
	 }
}
