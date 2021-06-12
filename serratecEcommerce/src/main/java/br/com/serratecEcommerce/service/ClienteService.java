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
import br.com.serratecEcommerce.model.Endereco;
import br.com.serratecEcommerce.model.exception.ResourceBadRequestException;
import br.com.serratecEcommerce.model.exception.ResourceNotFoundException;
import br.com.serratecEcommerce.repository.ClienteRepository;
import br.com.serratecEcommerce.repository.EnderecoRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository _repositorioCliente;
	
	@Autowired
	private EnderecoRepository _repositorioEndereco;
	
	@Autowired
	private CepService servicoCep;
	
	
	public List<Cliente> obterTodos(){
		return this._repositorioCliente.findAll();
	}
	
	public Cliente obterPorId(Long id){
		return this._repositorioCliente.findById(id)
									   .orElseThrow( ()-> new ResourceNotFoundException("Cliente não encontrado(a) pelo ID:" + id));
		
	}
	
	public List<Cliente> obterPorNome(String nome){
		var clientes = this._repositorioCliente.findByNome(nome);
		if (clientes.isEmpty())
			throw new ResourceNotFoundException("Cliente não encontrado(a) pelo Nome:" + nome);
		return clientes;
	}
	
	public ResponseEntity<Cliente> adicionar(Cliente cliente) {
		validaCpf(cliente.getCpfOuCnpj());
		autocompletarEndereco(cliente.getEndereco());
 		validarEndereco(cliente.getEndereco());
		cliente.setId(null);
		var adicionado = this._repositorioCliente.save(cliente);
		return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
	}
	
	 public Cliente atualizar(Long id,Cliente cliente) {
 		 Cliente clienteAtual = _repositorioCliente.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Cliente não encontrado(a) pelo ID:" + id));
 		 validaCpf(cliente.getCpfOuCnpj());
 		 autocompletarEndereco(cliente.getEndereco());
 		 validarEndereco(cliente.getEndereco());
 		 cliente.setId(id);
 		 cliente.setCpfOuCnpj(clienteAtual.getCpfOuCnpj());
 		 if (!clienteAtual.getEndereco().getId().equals(null))
			this._repositorioEndereco.deleteById(clienteAtual.getEndereco().getId());
         return this._repositorioCliente.save(cliente);
	 }

	 public void deletar(Long id) {
		 var cliente = _repositorioCliente.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Cliente não encontrado(a) pelo ID:" + id));
		 if (!cliente.getEndereco().getId().equals(null))
				this._repositorioEndereco.deleteById(cliente.getEndereco().getId());
		 this._repositorioCliente.deleteById(id);
		 
	 }
	 
	 private void validaCpf(String cpf) {
		    CPFValidator cpfValidator = new CPFValidator(); 
		    List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf); 
		    if (!erros.isEmpty())
		    	throw new ResourceBadRequestException("CPF é inválido!");
	 }	 
	 
	 private void validarEndereco(Endereco endereco) {
			Endereco enderecoCorreto = servicoCep.obterEnderecoPorCep(endereco.getCep());
			if (!endereco.getRua().equals(enderecoCorreto.getRua()) ) 
				throw new ResourceBadRequestException("A rua não conferi com seu CEP!");
			if (!endereco.getBairro().equals(enderecoCorreto.getBairro()) )
				throw new ResourceBadRequestException("O bairro não confere com seu CEP!");
			if (!endereco.getCidade().equals(enderecoCorreto.getCidade()) )
				throw new ResourceBadRequestException("A cidade não confere com seu CEP!");
			if (!endereco.getComplemento().equals(enderecoCorreto.getComplemento()) )
				throw new ResourceBadRequestException("O complemento não confere com seu CEP!");
			if (!endereco.getEstado().equals(enderecoCorreto.getEstado()) )
				throw new ResourceBadRequestException("O estado não confere com seu CEP!");	
		}
	 
	 	private void autocompletarEndereco(Endereco endereco) {
			Endereco enderecoCorreto = servicoCep.obterEnderecoPorCep(endereco.getCep());
			if (endereco.getRua() == null ) 
				endereco.setRua(enderecoCorreto.getRua());
			if (endereco.getBairro() == null)
				endereco.setBairro(enderecoCorreto.getBairro());
			if (endereco.getCidade() == null )
				endereco.setCidade(enderecoCorreto.getCidade());
			if (endereco.getComplemento() == null)
				endereco.setComplemento(enderecoCorreto.getComplemento());
			if (endereco.getEstado() == null )
				endereco.setEstado(enderecoCorreto.getEstado());
		}
}
