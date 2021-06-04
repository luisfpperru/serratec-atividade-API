package br.com.serratec.lojaserratec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.lojaserratec.model.Cliente;
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
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<Produto>> obterPorId(@PathVariable(value="id") Long id){
		var encontrado = this._repositorioProduto.findById(id);
		if (encontrado.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(encontrado, HttpStatus.OK);
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> obterPorNome(@PathVariable(value="nome") String nome){
		var encontrado = this._repositorioProduto.findByNome(nome);
		if (encontrado.isEmpty())
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(encontrado, HttpStatus.OK);
	}
	
    @PostMapping
    public ResponseEntity<Produto> adicionar(@RequestBody Produto produto) {
        var adicionado = this._repositorioProduto.save(produto);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable(value = "id") Long id, @RequestBody Produto produto) {
       	if (_repositorioProduto.findById(id).isPresent()) {
       			produto.setId(id);
        		var atualizado = this._repositorioProduto.save(produto);
        		return new ResponseEntity<>(atualizado, HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Produto> deletar(@PathVariable(value = "id") Long id) {
        try {
            this._repositorioProduto.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
            }
            catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

    }
	
}
