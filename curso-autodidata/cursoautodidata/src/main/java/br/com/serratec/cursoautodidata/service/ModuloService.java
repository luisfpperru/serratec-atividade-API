package br.com.serratec.cursoautodidata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratec.cursoautodidata.model.Modulo;
import br.com.serratec.cursoautodidata.repository.ModuloRepository;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository _repositorioModulo;

    public List<Modulo> obterTodos(){
        return this._repositorioModulo.findAll();
    }

    public Optional<Modulo> obterPorId(Long id){
        return this._repositorioModulo.findById(id);
    }

    public List<Modulo> obterPorNome(String nome){
        return this._repositorioModulo.findByNome(nome);
    }

    public ResponseEntity<Modulo> adicionar(Modulo modulo) {
        modulo.setId(null);
        var adicionado = this._repositorioModulo.save(modulo);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
    }
}