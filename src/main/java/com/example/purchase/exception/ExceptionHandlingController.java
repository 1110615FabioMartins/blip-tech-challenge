package com.example.purchase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Class that makes use of the spring AOP and intercepts all the unhandled
 * exceptions that are thrown in the applications and handles those exceptions
 **/

@ControllerAdvice
public class ExceptionHandlingController {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> generalException(Exception e) {
		ExceptionResponse eR = new ExceptionResponse();
		eR.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		eR.setDescription(e.getMessage());
		System.out.println(e);
		return new ResponseEntity<ExceptionResponse>(eR, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(PurchaseException.class)
	public ResponseEntity<ExceptionResponse> purchaseException(PurchaseException e) {
		ExceptionResponse eR = new ExceptionResponse();
		eR.setCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
		eR.setDescription(e.getMessage());
		System.out.println(e);
		return new ResponseEntity<ExceptionResponse>(eR, HttpStatus.UNPROCESSABLE_ENTITY);

	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ExceptionResponse> notFoundException(NotFoundException e) {
		ExceptionResponse eR = new ExceptionResponse();
		eR.setCode(HttpStatus.NOT_FOUND.value());
		eR.setDescription(e.getMessage());
		System.out.println(e);
		return new ResponseEntity<ExceptionResponse>(eR, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidParametersException.class)
	public ResponseEntity<ExceptionResponse> invalidParametersException(NotFoundException e) {
		ExceptionResponse eR = new ExceptionResponse();
		eR.setCode(HttpStatus.BAD_REQUEST.value());
		eR.setDescription(e.getMessage());
		System.out.println(e);
		return new ResponseEntity<ExceptionResponse>(eR, HttpStatus.BAD_REQUEST);
	}

}
