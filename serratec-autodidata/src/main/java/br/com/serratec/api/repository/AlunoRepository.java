package br.com.serratec.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.api.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	public Optional <Aluno> findById(Long Id);
	
}
