package br.com.serratecEcommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratecEcommerce.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long>{
	public Optional<Categoria> findById(Long id);
}
