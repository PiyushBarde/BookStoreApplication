package com.bridgelabz.userregistration.exceptions;

public class UserException extends RuntimeException{      //<-custom exception class which shows the message we gave
															// when we throw any new exception
	public UserException(String message) {				//	exception.
		super(message);
	}
}
