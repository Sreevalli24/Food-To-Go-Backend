package com.example.exceptions;

public class CartException extends Exception{
	
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public CartException() {
		
	}
	
	public CartException(String msg){
		
		super(msg);
		this.message=msg;
	}

}
