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

import br.com.serratec.cursoautodidata.model.Aula;
import br.com.serratec.cursoautodidata.service.AulaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@Api(value = "API REST Serratec Curso Autodidata - Aula")
@RestController
@RequestMapping("/api/aulas")
public class AulaController {

    @Autowired
    AulaService _servicoAula;

    @ApiOperation(value = "Retorna uma lista com todos os Aulas")
    @GetMapping
    public List<Aula> obterTodos(){
        return _servicoAula.obterTodos();
    }

    @ApiOperation(value = "Retorna o Aula pelo ID")
    @GetMapping("/id/{id}")
    public Optional<Aula> obterPorId(@PathVariable(value = "id") Long id){
        return _servicoAula.obterPorId(id);
    }

    @ApiOperation(value = "Adiciona uma Aula")
    @PostMapping
    public ResponseEntity<Aula> adicionar(@RequestBody Aula aula){
        return _servicoAula.adicionar(aula);
    }
}
