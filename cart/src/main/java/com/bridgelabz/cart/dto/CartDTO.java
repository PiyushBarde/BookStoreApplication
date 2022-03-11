package com.bridgelabz.cart.dto;

import lombok.Data;

@Data
public class CartDTO {
	private int userId;
	private int bookId;
	private int quantity;
}
