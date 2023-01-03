package com.cts.addressbook.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.addressbook.exceptions.InvalidDataException;
import com.cts.addressbook.exceptions.NotFoundException;

@RestControllerAdvice
public class ContactsControllerAdvice {

	private Logger logger;
	
	public ContactsControllerAdvice() {
		this.logger = LoggerFactory.getLogger(this.getClass());
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> handleException(NotFoundException exp){
		logger.debug(exp.getMessage(), exp);
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<String> handleException(InvalidDataException exp){
		logger.debug(exp.getMessage(), exp);
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception exp){
		logger.error(exp.getMessage(), exp);
		return new ResponseEntity<String>("Some Server Side Error Occured! Please retry!", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
