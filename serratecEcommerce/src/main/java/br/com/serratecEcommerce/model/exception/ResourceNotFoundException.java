package br.com.serratecEcommerce.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 2126400313246539183L;

	public ResourceNotFoundException() {
		super("Recurso não foi encontrado");
	}
	
	public ResourceNotFoundException(String mensagem) {
		super(mensagem);
	}	
	
}
