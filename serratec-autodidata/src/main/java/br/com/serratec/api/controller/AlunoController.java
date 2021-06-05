package br.com.serratec.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.api.exceptions.NotFoundException;
import br.com.serratec.api.model.Aluno;
import br.com.serratec.api.repository.AlunoRepository;

	@RestController
	@RequestMapping("/api/alunos")
	public class AlunoController {

		@Autowired
		private AlunoRepository _repositorioAluno;
		
		@GetMapping
	    public List<Aluno> obter(){
	        return this._repositorioAluno.findAll();

	    }
		
		@GetMapping("/id/{id}")
		public Aluno obterPorId(@PathVariable(value="id") Long id){
			var procurado = _repositorioAluno.findById(id)
											 .orElseThrow( ()-> new NotFoundException("Estudante não encontrado(a) pelo ID:" + id));
			return procurado;
		}
		
		
	    @PostMapping
	    public ResponseEntity<Aluno> adicionar(@RequestBody Aluno aluno) {
	        var adicionado = this._repositorioAluno.save(aluno);
	        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
	    }

	    @PutMapping("/id/{id}")
	    public Aluno atualizar(@PathVariable(value = "id") Long id, @RequestBody Aluno aluno) {
	    		_repositorioAluno.findById(id)
	    						 .orElseThrow( ()-> new NotFoundException("Estudante não encontrado(a) pelo ID:" + id));
				aluno.setId(id);
	            var atualizado = this._repositorioAluno.save(aluno);
	            return atualizado;
	    }

	    @DeleteMapping("/id/{id}")
	    public void deletar(@PathVariable(value = "id") Long id) {
    			_repositorioAluno.findById(id)
    							 .orElseThrow( ()-> new NotFoundException("Estudante não encontrado(a) pelo ID:" + id));
	            this._repositorioAluno.deleteById(id);
	    }
		
}
