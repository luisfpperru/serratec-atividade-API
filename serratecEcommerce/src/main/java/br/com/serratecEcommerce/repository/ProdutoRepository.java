package br.com.serratecEcommerce.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratecEcommerce.model.Produto;



public interface ProdutoRepository extends JpaRepository<Produto,Long>{
	public Optional<Produto> findById(Long id);
}
