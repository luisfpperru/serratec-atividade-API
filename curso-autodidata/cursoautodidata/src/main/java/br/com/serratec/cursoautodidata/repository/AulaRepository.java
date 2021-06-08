package br.com.serratec.cursoautodidata.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.cursoautodidata.model.Aula;

public interface AulaRepository extends JpaRepository<Aula,Long>{
    public Optional<Aula> findById(Long id);
    public List<Aula> findByNome(String nome);
}
