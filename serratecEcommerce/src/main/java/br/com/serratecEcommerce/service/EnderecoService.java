package br.com.serratecEcommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratecEcommerce.model.Endereco;
import br.com.serratecEcommerce.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository _repositorioEndereco;
	
	public List<Endereco> obterTodos(){
		return this._repositorioEndereco.findAll();
		}

	public Optional<Endereco> obterPorId(Long id){
		return this._repositorioEndereco.findById(id);
	}
	
	public ResponseEntity<Endereco> adicionar(Endereco endereco){
		endereco.setId(null);
		var adicionado = this._repositorioEndereco.save(endereco);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
	}
	
	public Endereco atualizar(Long id, Endereco endereco) {
 		_repositorioEndereco.findById(id);
 						 //.orElseThrow( ()-> new NotFoundException("Endereço não encontrado(a) pelo ID:" + id));
 		 endereco.setId(id);
         return this._repositorioEndereco.save(endereco);
	 }

	public void deletar(Long id) {
			_repositorioEndereco.findById(id);
							 //.orElseThrow( ()-> new NotFoundException("Endereço não encontrado(a) pelo ID:" + id));
         this._repositorioEndereco.deleteById(id);
	 }
}
