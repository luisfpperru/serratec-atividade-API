package br.com.serratec.lojaeletronicos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.lojaeletronicos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long>{
	public Optional<Produto> findById(Long id);
}
