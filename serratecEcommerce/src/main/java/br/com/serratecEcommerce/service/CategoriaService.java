package br.com.serratecEcommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratecEcommerce.model.Categoria;
import br.com.serratecEcommerce.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository _repositorioCategoria;
	
	public List<Categoria> obterTodos(){
		return this._repositorioCategoria.findAll();
		}
	
	public Categoria adicionar(Categoria categoria) {
		categoria.setId(null);
		//Poderia validar se os campos obrigatorios foram preenchidos
		return this._repositorioCategoria.save(categoria);
	}
}
