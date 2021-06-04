package br.com.serratec.api.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{

    	@ExceptionHandler(NotFoundException.class)
    	public ResponseEntity<StandardError> handleAnyException(NotFoundException e, HttpServletRequest request){
    		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(),e.getMessage());
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    	}
}