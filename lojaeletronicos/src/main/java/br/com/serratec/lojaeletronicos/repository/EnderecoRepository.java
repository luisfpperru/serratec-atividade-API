package br.com.serratec.lojaeletronicos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.lojaeletronicos.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco,Long>{
	public Optional <Endereco> findById(Long Id);
}
