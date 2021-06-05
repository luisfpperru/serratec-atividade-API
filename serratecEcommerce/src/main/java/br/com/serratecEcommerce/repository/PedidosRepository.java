package br.com.serratec.lojaeletronicos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.lojaeletronicos.model.Pedidos;

public interface PedidosRepository extends JpaRepository<Pedidos,Long>{
	public Optional<Pedidos> findById(Long id);

}
