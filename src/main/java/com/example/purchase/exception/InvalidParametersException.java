package com.example.purchase.exception;

public class InvalidParametersException extends GenericPurchaseException{
	
	private static final long serialVersionUID = 1L;

	public InvalidParametersException() {
		super();
	}
	
	public InvalidParametersException(int code,String message){
		super(code,message);		
	}

}
