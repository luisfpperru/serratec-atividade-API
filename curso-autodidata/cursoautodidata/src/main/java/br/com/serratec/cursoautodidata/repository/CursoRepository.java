package br.com.serratec.cursoautodidata.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.cursoautodidata.model.Curso;

public interface CursoRepository extends JpaRepository<Curso,Long>{
    public Optional<Curso> findById(Long id);
}
