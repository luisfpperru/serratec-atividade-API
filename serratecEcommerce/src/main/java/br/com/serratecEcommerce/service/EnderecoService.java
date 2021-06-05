package br.com.serratecEcommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public Endereco adicionar(Endereco endereco) {
		 endereco.setId(null);
		//Poderia validar se os campos obrigatorios foram preenchidos
		return this._repositorioEndereco.save(endereco);
	}
}
