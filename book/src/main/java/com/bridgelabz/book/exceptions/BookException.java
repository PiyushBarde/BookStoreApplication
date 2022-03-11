package com.bridgelabz.book.exceptions;

public class BookException extends RuntimeException{      //<-custom exception class which shows the message we gave
															// when we throw any new exception
	public BookException(String message) {				//	exception.
		super(message);
	}
}
