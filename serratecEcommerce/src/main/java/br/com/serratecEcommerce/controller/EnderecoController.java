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

import br.com.serratecEcommerce.model.Endereco;
import br.com.serratecEcommerce.repository.EnderecoRepository;



@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
	
	@Autowired
	EnderecoRepository _repositorioEndereco;
	
	@GetMapping
	public List<Endereco> obterTodos(){
		return this._repositorioEndereco.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Endereco> obterPorId(@PathVariable(value = "id") Long id){
		return this._repositorioEndereco.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Endereco>  adicionar(@RequestBody Endereco endereco){
		var adicionado = this._repositorioEndereco.save(endereco);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
	}
	
	 public Endereco atualizar(@PathVariable(value = "id") Long id, @RequestBody Endereco endereco) {
 		_repositorioEndereco.findById(id);
 						 //.orElseThrow( ()-> new NotFoundException("Endereço não encontrado(a) pelo ID:" + id));
 		 endereco.setId(id);
         return this._repositorioEndereco.save(endereco);
	 }

	 @DeleteMapping("/id/{id}")
	 public void deletar(@PathVariable(value = "id") Long id) {
			_repositorioEndereco.findById(id);
							 //.orElseThrow( ()-> new NotFoundException("Endereço não encontrado(a) pelo ID:" + id));
         this._repositorioEndereco.deleteById(id);
	 }
}
