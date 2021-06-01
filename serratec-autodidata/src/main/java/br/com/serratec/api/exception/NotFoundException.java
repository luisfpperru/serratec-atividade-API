package br.com.serratec.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public NotFoundException(String mensagem) {
		super(mensagem);
	}
}
