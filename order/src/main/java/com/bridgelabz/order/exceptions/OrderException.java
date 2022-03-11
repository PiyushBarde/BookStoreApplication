package com.bridgelabz.order.exceptions;

public class OrderException extends RuntimeException{      //<-custom exception class which shows the message we gave when we throw any new
	public OrderException(String message) {				//	exception.
		super(message);
	}
}
