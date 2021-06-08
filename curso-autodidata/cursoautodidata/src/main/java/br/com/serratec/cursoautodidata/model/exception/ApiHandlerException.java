package br.com.serratec.cursoautodidata.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.serratec.cursoautodidata.error.ErrorMessage;

@ControllerAdvice
public class ApiHandlerException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException exception){
		
		ErrorMessage errorMessage = new ErrorMessage(
				"Not Found",
				HttpStatus.NOT_FOUND.value(),
				exception.getMessage());
		
		
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ResourceBadRequestException.class)
	public ResponseEntity<?> handlerResourceBadRequestException(ResourceBadRequestException exception){
		ErrorMessage errorMessage = new ErrorMessage(
				"Bad Request",
				HttpStatus.BAD_REQUEST.value(),
				exception.getMessage());
		
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
}
