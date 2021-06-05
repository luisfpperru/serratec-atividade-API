package br.com.serratec.lojaeletronicos.controller;

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

import br.com.serratec.lojaeletronicos.model.Categoria;
import br.com.serratec.lojaeletronicos.repository.CategoriaRepository;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaRepository _repositorioCategoria;
	
	@GetMapping
	public List<Categoria> obterTodos(){
		return this._repositorioCategoria.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Categoria> obterPorId(@PathVariable(value = "id") Long id){
		return this._repositorioCategoria.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Categoria>  adicionar(@RequestBody Categoria categoria){
		var adicionado = this._repositorioCategoria.save(categoria);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
	}
	
	 public Categoria atualizar(@PathVariable(value = "id") Long id, @RequestBody Categoria categoria) {
 		_repositorioCategoria.findById(id);
 						 //.orElseThrow( ()-> new NotFoundException("Categoria não encontrada pelo ID:" + id));
 		 categoria.setId(id);
         return this._repositorioCategoria.save(categoria);
	 }

	 @DeleteMapping("/id/{id}")
	 public void deletar(@PathVariable(value = "id") Long id) {
			_repositorioCategoria.findById(id);
							 //.orElseThrow( ()-> new NotFoundException("Categoria não encontrada pelo ID:" + id));
         this._repositorioCategoria.deleteById(id);
	 }
}
