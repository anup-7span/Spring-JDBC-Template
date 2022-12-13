package com.JDBC.SpringJDBCTemplate.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> handleCustomException(CustomException ex) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getMessage());
		ErrorDTO errorDto = new ErrorDTO(errors,0);
		return ResponseEntity.status(ex.getHttpStatus()).body(errorDto);
	}

}