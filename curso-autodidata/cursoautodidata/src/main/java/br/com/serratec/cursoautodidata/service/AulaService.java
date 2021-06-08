package br.com.serratec.cursoautodidata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratec.cursoautodidata.model.Aula;
import br.com.serratec.cursoautodidata.model.exception.ResourceBadRequestException;
import br.com.serratec.cursoautodidata.model.exception.ResourceNotFoundException;
import br.com.serratec.cursoautodidata.repository.AulaRepository;

@Service
public class AulaService {

    @Autowired
    private AulaRepository _repositorioAula;

    public List<Aula> obterTodos(){
        return this._repositorioAula.findAll();
    }

    public Aula obterPorId(Long id){
        return this._repositorioAula.findById(id).orElseThrow( () -> new ResourceNotFoundException("Aula não encontrada pelo ID:"+ id));
    }

    public ResponseEntity<Aula> adicionar(Aula aula) {
    	this.validarCampos(aula);
        aula.setId(null);
        var adicionado = this._repositorioAula.save(aula);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
    }
    
    private void validarCampos(Aula aula) {
    	if (aula.getDescricao() == null)
    		throw new ResourceBadRequestException("A descrição é um campo obrigatório!");
    	if (aula.getCargaHoraria() == null)
    		throw new ResourceBadRequestException("A carga horária é um campo obrigatório!");
    }
}