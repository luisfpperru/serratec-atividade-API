package br.com.serratecEcommerce.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratecEcommerce.model.Endereco;
import br.com.serratecEcommerce.model.exception.ResourceBadRequestException;
import br.com.serratecEcommerce.model.exception.ResourceNotFoundException;
import br.com.serratecEcommerce.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository _repositorioEndereco;
	
	@Autowired
	private CepService servicoCep;
	
	public List<Endereco> obterTodos(){
		return this._repositorioEndereco.findAll();
		}

	public Optional<Endereco> obterPorId(Long id){
		return this._repositorioEndereco.findById(id);
	}
	
	public ResponseEntity<Endereco> adicionar(Endereco endereco){
 		this.autocompletarEndereco(endereco);
		this.validarEndereco(endereco);
		endereco.setId(null);
		var adicionado = this._repositorioEndereco.save(endereco);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
	}
	
	public Endereco atualizar(Long id, Endereco endereco) {
 		_repositorioEndereco.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Endereço não encontrado(a) pelo ID:" + id));
 		this.autocompletarEndereco(endereco);
 		this.validarEndereco(endereco);
 		 endereco.setId(id);
         return this._repositorioEndereco.save(endereco);
	 }

	public void deletar(Long id) {
			_repositorioEndereco.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Endereço não encontrado(a) pelo ID:" + id));
         this._repositorioEndereco.deleteById(id);
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
