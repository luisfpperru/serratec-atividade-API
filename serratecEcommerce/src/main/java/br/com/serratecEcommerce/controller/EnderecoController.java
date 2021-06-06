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

import br.com.serratecEcommerce.model.Endereco;
import br.com.serratecEcommerce.service.EnderecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@Api(value = "API REST Serratec E-Commerce - ENDEREÇO")
@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
	
	@Autowired
	EnderecoService _servicoEndereco;
	
	@ApiOperation(value = "Retorna uma lista com todos os endereços")
	@GetMapping
	public List<Endereco> obterTodos(){
		return _servicoEndereco.obterTodos();
	}

	@ApiOperation(value = "Retorna um endereço pelo ID")
	@GetMapping("/{id}")
	public Optional<Endereco> obterPorId(@PathVariable(value = "id") Long id){
		return _servicoEndereco.obterPorId(id);
	}
	
	@ApiOperation(value = "Adiciona um endereço")
	@PostMapping
	public ResponseEntity<Endereco>  adicionar(@RequestBody Endereco endereco){
        return _servicoEndereco.adicionar(endereco);
	}
	
	@ApiOperation(value = "Atualiza um endereço existente")
	@PutMapping("/id/{id}")
	public Endereco atualizar(@PathVariable(value = "id") Long id, @RequestBody Endereco endereco) {
         return _servicoEndereco.atualizar(id,endereco);
	 }

	@ApiOperation(value = "Deleta um endereço existente")
	@DeleteMapping("/id/{id}")
	public void deletar(@PathVariable(value = "id") Long id) {
		_servicoEndereco.deletar(id);
	 }
}
