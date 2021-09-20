package com.example.apirest1.handler;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.apirest1.exception.ExceptionResponse;
import com.example.apirest1.exception.IncorrectOrderRequestException;
import com.example.apirest1.exception.OrderNotFoundException;

@ControllerAdvice
@RestController
public class ExceptionCatcher extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handlerAllException(Exception exception, WebRequest request){
		ExceptionResponse response = new ExceptionResponse(exception.getMessage(),
									request.getDescription(true),
									HttpStatus.INTERNAL_SERVER_ERROR,
									LocalDateTime.now());
		return new ResponseEntity<Object>(response,response.getStatus());		
	}
	
	@ExceptionHandler(IncorrectOrderRequestException.class)
	public ResponseEntity<Object> handlerIncorrectOrderException(IncorrectOrderRequestException exception, WebRequest request){
		ExceptionResponse response = new ExceptionResponse(exception.getMessage(),
									request.getDescription(true),
									HttpStatus.BAD_REQUEST,
									LocalDateTime.now());
		return new ResponseEntity<Object>(response,response.getStatus());		
	}	
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<Object> handlerOrderNotFoundException(OrderNotFoundException exception, WebRequest request){
		System.out.println("Holiiiii ");
		ExceptionResponse response = new ExceptionResponse(exception.getMessage(),
									request.getDescription(true),
									HttpStatus.NOT_FOUND,
									LocalDateTime.now());
		return new ResponseEntity<Object>(response,response.getStatus());		
	}	
	
		
	
}
