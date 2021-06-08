package br.com.serratec.cursoautodidata.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.cursoautodidata.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno,Long>{
    public Optional<Aluno> findById(Long id);
    public List<Aluno> findByNome(String nome);
}
