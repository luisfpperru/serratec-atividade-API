package br.com.serratec.lojaeletronicos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.lojaeletronicos.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{
	public Optional<Cliente> findById(Long id);
}
