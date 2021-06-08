package br.com.serratec.cursoautodidata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratec.cursoautodidata.model.Aluno;
import br.com.serratec.cursoautodidata.model.exception.ResourceBadRequestException;
import br.com.serratec.cursoautodidata.model.exception.ResourceNotFoundException;
import br.com.serratec.cursoautodidata.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository _repositorioAluno;

    public List<Aluno> obterTodos(){
        return this._repositorioAluno.findAll();
    }

    public Aluno obterPorId(Long id){
        return this._repositorioAluno.findById(id).orElseThrow( () -> new ResourceNotFoundException("Aluno não encontrado pelo ID:"+ id));
    }

    public List<Aluno> obterPorNome(String nome){
    	var listaAlunos = this._repositorioAluno.findByNome(nome);
    	if (listaAlunos.isEmpty()) {
    		throw new ResourceNotFoundException("Aluno não encontrado pelo nome:"+ nome);
    	}
        return listaAlunos;
    }

    public ResponseEntity<Aluno> adicionar(Aluno aluno) {
    	this.validarCampos(aluno);
        aluno.setId(null);
        var adicionado = this._repositorioAluno.save(aluno);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
    }
    
    private void validarCampos(Aluno aluno) {
    	if (aluno.getNome() == null)
    		throw new ResourceBadRequestException("O nome é um campo obrigatório!");
    	if (aluno.getIdade() == null)
    		throw new ResourceBadRequestException("A idade é um campo obrigatório!");
    }
 }
