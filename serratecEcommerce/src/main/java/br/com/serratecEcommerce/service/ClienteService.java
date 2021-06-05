package br.com.serratecEcommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.serratecEcommerce.model.Cliente;
import br.com.serratecEcommerce.repository.ClienteRepository;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository _repositorioCliente;
	
	public List<Cliente> obterTodos(){
		return this._repositorioCliente.findAll();
		}
	
	public Optional<Cliente> obterPorId(Long id){
		return this._repositorioCliente.findById(id);
	}
	
	public List<Cliente> obterPorNome(String nome){
		return this._repositorioCliente.findByName(nome);
	}
	
	public ResponseEntity<Cliente> adicionar(Cliente cliente) {
		cliente.setId(null);
		var adicionado = this._repositorioCliente.save(cliente);
		return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
	}
	
	 public Cliente atualizar(Long id,Cliente cliente) {
 		_repositorioCliente.findById(id);
 						 //.orElseThrow( ()-> new NotFoundException("Cliente não encontrado(a) pelo ID:" + id));
 		 cliente.setId(id);
         return this._repositorioCliente.save(cliente);
	 }

	 public void deletar(Long id) {
			_repositorioCliente.findById(id);
							 //.orElseThrow( ()-> new NotFoundException("Cliente não encontrado(a) pelo ID:" + id));
         this._repositorioCliente.deleteById(id);
	 }
}
