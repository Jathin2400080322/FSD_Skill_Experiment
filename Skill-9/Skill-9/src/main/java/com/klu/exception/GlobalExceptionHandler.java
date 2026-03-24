package com.klu.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(StudentNotFoundException.class)
	  public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(StudentNotFoundException e) {
	    Map<String,Object> error = new HashMap<>();
	    error.put("timestamp", LocalDateTime.now());
	    error.put("message", e.getMessage());
	    error.put("status", HttpStatus.NOT_FOUND.value());
	    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	  }
	  
	  @ExceptionHandler(Exception.class)
	  public ResponseEntity<Map<String,Object>> handleGenericException(Exception e){
	    Map<String,Object> error = new HashMap<>();
	    error.put("timestamp", LocalDateTime.now());
	    error.put("message", e.getMessage());
	    error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
	    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
}
