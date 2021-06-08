package br.com.serratec.cursoautodidata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratec.cursoautodidata.model.Modulo;
import br.com.serratec.cursoautodidata.model.exception.ResourceBadRequestException;
import br.com.serratec.cursoautodidata.model.exception.ResourceNotFoundException;
import br.com.serratec.cursoautodidata.repository.ModuloRepository;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository _repositorioModulo;

    public List<Modulo> obterTodos(){
        return this._repositorioModulo.findAll();
    }

    public Modulo obterPorId(Long id){
        return this._repositorioModulo.findById(id).orElseThrow( () -> new ResourceNotFoundException("Módulo não encontrado pelo ID:"+ id));
    }

    public ResponseEntity<Modulo> adicionar(Modulo modulo) {
    	this.validarCampos(modulo);
        modulo.setId(null);
        var adicionado = this._repositorioModulo.save(modulo);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
    }
    
    private void validarCampos(Modulo modulo) {
    	if (modulo.getDescricao() == null)
    		throw new ResourceBadRequestException("O descrição é um campo obrigatório!");
    }
}