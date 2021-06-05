package br.com.serratec.lojaeletronicos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.lojaeletronicos.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long>{
	public Optional<Categoria> findById(Long id);
}
