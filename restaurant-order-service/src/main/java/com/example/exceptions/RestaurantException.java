package com.example.exceptions;

public class RestaurantException extends RuntimeException{
	

	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public RestaurantException() {
		
	}
	
	
	public RestaurantException(String msg){
		
		super(msg);
		this.message=msg;
	}
}
