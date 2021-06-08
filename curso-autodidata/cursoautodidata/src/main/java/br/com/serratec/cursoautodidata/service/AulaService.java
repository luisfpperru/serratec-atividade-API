package br.com.serratec.cursoautodidata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratec.cursoautodidata.model.Aula;
import br.com.serratec.cursoautodidata.repository.AulaRepository;

@Service
public class AulaService {

    @Autowired
    private AulaRepository _repositorioAula;

    public List<Aula> obterTodos(){
        return this._repositorioAula.findAll();
    }

    public Optional<Aula> obterPorId(Long id){
        return this._repositorioAula.findById(id);
    }

    public List<Aula> obterPorNome(String nome){
        return this._repositorioAula.findByNome(nome);
    }

    public ResponseEntity<Aula> adicionar(Aula aula) {
        aula.setId(null);
        var adicionado = this._repositorioAula.save(aula);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
    }
}