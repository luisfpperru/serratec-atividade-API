package br.com.serratec.lojaserratec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.lojaserratec.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	public Optional<Cliente> findById(Long id);
}