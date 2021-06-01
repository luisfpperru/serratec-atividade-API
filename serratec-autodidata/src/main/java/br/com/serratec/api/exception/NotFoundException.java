package br.com.serratec.api.exception;

public class NotFoundException extends RuntimeException {
	
	public NotFoundException(String mensagem) {
		super(mensagem);
	}
}
