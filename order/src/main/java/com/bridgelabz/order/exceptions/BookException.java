package com.bridgelabz.order.exceptions;

public class BookException extends RuntimeException{      //<-custom exception class which shows the message we gave when we throw any new
	public BookException(String message) {				//	exception.
		super(message);
	}
}
