package com.example.purchase.exception;

public class NotFoundException extends GenericPurchaseException {

	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super();
	}
	
	public NotFoundException(int code,String message){
		super(code,message);		
	}
}
