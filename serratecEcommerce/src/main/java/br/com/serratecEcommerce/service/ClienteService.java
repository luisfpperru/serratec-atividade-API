package br.com.serratecEcommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.serratecEcommerce.model.Cliente;
import br.com.serratecEcommerce.model.exception.ResourceBadRequestException;
import br.com.serratecEcommerce.model.exception.ResourceNotFoundException;
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
		return this._repositorioCliente.findByNome(nome);
	}
	
	public ResponseEntity<Cliente> adicionar(Cliente cliente) {
		validaCpf(cliente.getCpfOuCnpj());
		cliente.setId(null);
		var adicionado = this._repositorioCliente.save(cliente);
		return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
	}
	
	 public Cliente atualizar(Long id,Cliente cliente) {
 		 Cliente clienteAtual = _repositorioCliente.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Cliente não encontrado(a) pelo ID:" + id));
 		 validaCpf(cliente.getCpfOuCnpj());
 		 cliente.setId(id);
 		 cliente.setCpfOuCnpj(clienteAtual.getCpfOuCnpj());
         return this._repositorioCliente.save(cliente);
	 }

	 public void deletar(Long id) {
			_repositorioCliente.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Cliente não encontrado(a) pelo ID:" + id));
         this._repositorioCliente.deleteById(id);
	 }
	 
	 private void validaCpf(String cpf) {
		    CPFValidator cpfValidator = new CPFValidator(); 
		    List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf); 
		    if (!erros.isEmpty())
		    	throw new ResourceBadRequestException("CPF é inválido!");
	 }	 
}
