package com.bridgelabz.book.dto;

import lombok.Data;

@Data
public class QuantityDTO {
	private Integer bookId;
	private int quantity;
	public QuantityDTO() {
		super();
	}
	
}
