package br.com.serratec.lojaserratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.lojaserratec.model.Produto;
import br.com.serratec.lojaserratec.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    
	@Autowired
	private ProdutoRepository _repositorioProduto;
	
	@GetMapping
	public List<Produto> obter(){
		return this._repositorioProduto.findAll();
		
	}
	
	@PostMapping
	public Produto adicionar(@RequestBody Produto produto) {
		return this._repositorioProduto.save(produto);
	}
	
	@PutMapping("/{id}")
	public Produto atualizar(@PathVariable(value = "id") Long id, @RequestBody Produto produto) {
		produto.setId(id);
		return this._repositorioProduto.save(produto);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable(value = "id") Long id) {
		this._repositorioProduto.deleteById(id);
	}
	
	//@GetMapping("/{nome}")
	//public List<Produto> obterPorNome(@PathVariable(value = "nome") String nome){
	//	return _repositorioProduto.find;
	//}
	
	
}
