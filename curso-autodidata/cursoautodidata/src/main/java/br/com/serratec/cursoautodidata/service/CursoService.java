package br.com.serratec.cursoautodidata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratec.cursoautodidata.model.Curso;
import br.com.serratec.cursoautodidata.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository _repositorioCurso;

    public List<Curso> obterTodos(){
        return this._repositorioCurso.findAll();
    }

    public Optional<Curso> obterPorId(Long id){
        return this._repositorioCurso.findById(id);
    }

    public List<Curso> obterPorNome(String nome){
        return this._repositorioCurso.findByNome(nome);
    }

    public ResponseEntity<Curso> adicionar(Curso curso) {
        curso.setId(null);
        var adicionado = this._repositorioCurso.save(curso);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
    }
}