package br.com.serratec.cursoautodidata.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.cursoautodidata.model.Aluno;
import br.com.serratec.cursoautodidata.service.AlunoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@Api(value = "API REST Serratec Curso Autodidata - Aluno")
@RestController
@RequestMapping("/api/Alunos")
public class AlunoController {

    @Autowired
    AlunoService _servicoAluno;

    @ApiOperation(value = "Retorna uma lista com todos os Alunos")
    @GetMapping
    public List<Aluno> obterTodos(){
        return _servicoAluno.obterTodos();
    }

    @ApiOperation(value = "Retorna o Aluno pelo ID")
    @GetMapping("/id/{id}")
    public Optional<Aluno> obterPorId(@PathVariable(value = "id") Long id){
        return _servicoAluno.obterPorId(id);
    }

    @ApiOperation(value = "Retorna o Aluno pelo nome")
    @GetMapping("/nome/{nome}")
    public List<Aluno> obterPorNome(@PathVariable(value = "nome") String nome){
        return _servicoAluno.obterPorNome(nome);
    }

    @ApiOperation(value = "Adiciona um Aluno")
    @PostMapping
    public ResponseEntity<Aluno> adicionar(@RequestBody Aluno aluno){
        return _servicoAluno.adicionar(aluno);
    }
}
