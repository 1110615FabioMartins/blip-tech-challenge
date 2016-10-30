package com.example.purchase.exception;

public class PurchaseException extends GenericPurchaseException{
	
	private static final long serialVersionUID = 1L;

	public PurchaseException() {
		super();
	}
	
	public PurchaseException(int code,String message){
		super(code,message);		
	}
	

}
