package br.com.serratec.lojaserratec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.lojaserratec.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	public Optional<Produto> findById(Long id);
	
	public List<Produto> findByNome(String nome);
}