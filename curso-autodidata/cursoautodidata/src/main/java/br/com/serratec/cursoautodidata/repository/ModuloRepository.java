package br.com.serratec.cursoautodidata.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.cursoautodidata.model.Modulo;

public interface ModuloRepository extends JpaRepository<Modulo,Long>{
    public Optional<Modulo> findById(Long id);
}
