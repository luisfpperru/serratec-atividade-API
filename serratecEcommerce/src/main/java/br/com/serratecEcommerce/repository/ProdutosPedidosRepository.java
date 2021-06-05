package br.com.serratecEcommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratecEcommerce.model.ProdutosPedidos;



public interface ProdutosPedidosRepository extends JpaRepository<ProdutosPedidos,Long>{
	public Optional<ProdutosPedidos> findById(Long id);

}
