package br.com.serratecEcommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratecEcommerce.model.Cliente;
import br.com.serratecEcommerce.repository.ClienteRepository;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository _repositorioCliente;
	
	public List<Cliente> obterTodos(){
		return this._repositorioCliente.findAll();
		}
	
	public Cliente adicionar(Cliente cliente) {
		cliente.setId(null);
		//Poderia validar se os campos obrigatorios foram preenchidos
		return this._repositorioCliente.save(cliente);
	}
}
