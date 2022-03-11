package com.bridgelabz.cart.dto;

import lombok.Data;

@Data
public class QuantityDTO {
	private Integer cartID;
	private int quantity;
	public QuantityDTO() {
		super();
	}
	
	
}
