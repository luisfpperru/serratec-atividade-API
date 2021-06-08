package br.com.serratec.cursoautodidata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.cursoautodidata.model.Curso;
import br.com.serratec.cursoautodidata.service.CursoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@Api(value = "API REST Serratec Curso Autodidata - Curso")
@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    CursoService _servicoCurso;

    @ApiOperation(value = "Retorna uma lista com todos os Cursos")
    @GetMapping
    public List<Curso> obterTodos(){
        return _servicoCurso.obterTodos();
    }

    @ApiOperation(value = "Retorna o Curso pelo ID")
    @GetMapping("/{id}")
    public Curso obterPorId(@PathVariable(value = "id") Long id){
        return _servicoCurso.obterPorId(id);
    }

    @ApiOperation(value = "Adiciona um Curso")
    @PostMapping
    public ResponseEntity<Curso> adicionar(@RequestBody Curso curso){
        return _servicoCurso.adicionar(curso);
    }
}
