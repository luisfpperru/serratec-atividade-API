package br.com.serratec.lojaserratec.controller;

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

import br.com.serratec.lojaserratec.model.Cliente;
import br.com.serratec.lojaserratec.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository _repositorioCliente;
	
	@GetMapping
    public List<Cliente> obter(){
        return this._repositorioCliente.findAll();

    }
	
	@GetMapping("/nome/{nome}")
	public Optional<Cliente> obterPorNome(@PathVariable(value="nome") String nome){
		return this._repositorioCliente.findByNome(nome);
	}
	

    @PostMapping
    public ResponseEntity<Cliente> adicionar(@RequestBody Cliente cliente) {
        var adicionado = this._repositorioCliente.save(cliente);
        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable(value = "id") Long id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        try {
            var atualizado = this._repositorioCliente.save(cliente);
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
            }
            catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deletar(@PathVariable(value = "id") Long id) {
        try {
            this._repositorioCliente.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
            }
            catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }
	
}
