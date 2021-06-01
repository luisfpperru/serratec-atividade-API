package br.com.serratec.api.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.serratec.api.exception.NotFoundException;
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
		public ResponseEntity<Optional<Aluno>> obterPorId(@PathVariable(value="id") Long id){
			verificarSeEstudanteExiste(id);
			var procurado = _repositorioAluno.findById(id);
			return new ResponseEntity<>(procurado,HttpStatus.OK);
		}
		
		
	    @PostMapping
	    public ResponseEntity<Aluno> adicionar(@RequestBody Aluno aluno) {
	        var adicionado = this._repositorioAluno.save(aluno);
	        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
	    }

	    @PutMapping("/id/{id}")
	    public ResponseEntity<Aluno> atualizar(@PathVariable(value = "id") Long id, @RequestBody Aluno aluno) {
				verificarSeEstudanteExiste(id);
				aluno.setId(id);
	            var atualizado = this._repositorioAluno.save(aluno);
	            return new ResponseEntity<>(atualizado, HttpStatus.OK);
	    }

	    @DeleteMapping("/id/{id}")
	    public ResponseEntity<Aluno> deletar(@PathVariable(value = "id") Long id) {
			    verificarSeEstudanteExiste(id);
	            this._repositorioAluno.deleteById(id);
	            return new ResponseEntity<>(HttpStatus.OK);       
	    }
		
	    private void verificarSeEstudanteExiste(Long id) {
	    	if (_repositorioAluno.findById(id) == null) 
	    		throw new NotFoundException("Estudante não encontrado(a) pelo ID:" + id);
	    }
}
