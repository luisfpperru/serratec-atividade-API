package br.com.serratec.cursoautodidata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratec.cursoautodidata.model.Curso;
import br.com.serratec.cursoautodidata.model.exception.ResourceBadRequestException;
import br.com.serratec.cursoautodidata.model.exception.ResourceNotFoundException;
import br.com.serratec.cursoautodidata.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository _repositorioCurso;

    public List<Curso> obterTodos(){
        return this._repositorioCurso.findAll();
    }

    public Curso obterPorId(Long id){
        return this._repositorioCurso.findById(id).orElseThrow( () -> new ResourceNotFoundException("Curso não encontrado pelo ID:"+ id));
    }

    public ResponseEntity<Curso> adicionar(Curso curso) {
    	this.validarCampos(curso);
        curso.setId(null);
        var adicionado = this._repositorioCurso.save(curso);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
    }
    
    private void validarCampos(Curso curso) {
    	if (curso.getDescricao() == null)
    		throw new ResourceBadRequestException("O descrição é um campo obrigatório!");
    }
}