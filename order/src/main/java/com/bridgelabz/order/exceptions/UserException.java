package com.bridgelabz.order.exceptions;

public class UserException extends RuntimeException{      //<-custom exception class which shows the message we gave when we throw any new
	public UserException(String message) {				//	exception.
		super(message);
	}
}
