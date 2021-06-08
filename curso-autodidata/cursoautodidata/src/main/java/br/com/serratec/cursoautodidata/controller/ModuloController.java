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

import br.com.serratec.cursoautodidata.model.Modulo;
import br.com.serratec.cursoautodidata.service.ModuloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@Api(value = "API REST Serratec Curso Autodidata - Modulo")
@RestController
@RequestMapping("/api/modulos")
public class ModuloController {

    @Autowired
    ModuloService _servicoModulo;

    @ApiOperation(value = "Retorna uma lista com todos os Modulos")
    @GetMapping
    public List<Modulo> obterTodos(){
        return _servicoModulo.obterTodos();
    }

    @ApiOperation(value = "Retorna o Modulo pelo ID")
    @GetMapping("/{id}")
    public Modulo obterPorId(@PathVariable(value = "id") Long id){
        return _servicoModulo.obterPorId(id);
    }

    @ApiOperation(value = "Adiciona um Modulo")
    @PostMapping
    public ResponseEntity<Modulo> adicionar(@RequestBody Modulo modulo){
        return _servicoModulo.adicionar(modulo);
    }
}
