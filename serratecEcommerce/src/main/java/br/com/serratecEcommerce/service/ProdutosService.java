package br.com.serratecEcommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.serratecEcommerce.model.Produto;
import br.com.serratecEcommerce.repository.ProdutoRepository;


@Service
public class ProdutosService {

	@Autowired
	private ProdutoRepository _repositorioProduto;
	
	public List<Produto> obterTodos(){
		return this._repositorioProduto.findAll();
		}
	
	public Produto adicionar(Produto produto) {
		produto.setId(null);
		//Poderia validar se os campos obrigatorios foram preenchidos
		return this._repositorioProduto.save(produto);
	}
}
