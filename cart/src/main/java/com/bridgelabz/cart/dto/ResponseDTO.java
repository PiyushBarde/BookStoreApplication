package com.bridgelabz.cart.dto;

import lombok.Data;

@Data
public class ResponseDTO {

	private String message;
	private Object object;
	
	public ResponseDTO(String message, Object insertItemsInCart) {
		this.message=message;
		this.object=insertItemsInCart;
	}
}
