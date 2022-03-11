package com.bridgelabz.cart.exceptions;

public class CartException extends RuntimeException{      //<-custom exception class which shows the message we gave
															// when we throw any new exception
	public CartException(String message) {				//	exception.
		super(message);
	}
}
