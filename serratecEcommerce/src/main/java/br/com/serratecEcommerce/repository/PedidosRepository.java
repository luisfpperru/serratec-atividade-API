package br.com.serratecEcommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratecEcommerce.model.Pedidos;



public interface PedidosRepository extends JpaRepository<Pedidos,Long>{
	public Optional<Pedidos> findById(Long id);

}
