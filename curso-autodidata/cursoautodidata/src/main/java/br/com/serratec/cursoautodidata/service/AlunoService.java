package br.com.serratec.cursoautodidata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratec.cursoautodidata.model.Aluno;
import br.com.serratec.cursoautodidata.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository _repositorioAluno;

    public List<Aluno> obterTodos(){
        return this._repositorioAluno.findAll();
    }

    public Optional<Aluno> obterPorId(Long id){
        return this._repositorioAluno.findById(id);
    }

    public List<Aluno> obterPorNome(String nome){
        return this._repositorioAluno.findByNome(nome);
    }

    public ResponseEntity<Aluno> adicionar(Aluno aluno) {
        aluno.setId(null);
        var adicionado = this._repositorioAluno.save(aluno);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
    }
}