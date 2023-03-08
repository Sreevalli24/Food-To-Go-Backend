package com.example.exceptions;

public class OrdersException extends Exception{
	

	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	public OrdersException() {
		
	}
	
	public OrdersException(String msg) {
		
		super(msg);
		this.message=msg;
	}
	

}
