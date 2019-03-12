package com.mutants.exceptions.handlers;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public ResponseEntity<?> handle(ArrayIndexOutOfBoundsException e) {

		CustomErrorDetails error = CustomErrorDetails.builder().timestamp(LocalDate.now())
				.message("O dna deve conter a regra N x N")
				.details(e.getMessage()).build();

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handle(Exception e) {

		CustomErrorDetails error = CustomErrorDetails.builder().timestamp(LocalDate.now())
				.message("Ops! Estamos com algum problema, tente mais tarde.")
				.details(e.getMessage()).build();

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
