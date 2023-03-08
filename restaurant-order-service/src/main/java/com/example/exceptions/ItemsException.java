package com.example.exceptions;

public class ItemsException extends Exception {
	
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public ItemsException() {
	
	}
	
	public ItemsException(String msg) {
		
		super(msg);
		this.message=msg;
		
	}

}
