package br.com.serratec.lojaeletronicos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.lojaeletronicos.model.ProdutosPedidos;

public interface ProdutosPedidosRepository extends JpaRepository<ProdutosPedidos,Long>{
	public Optional<ProdutosPedidos> findById(Long id);

}
