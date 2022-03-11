package com.bridgelabz.cart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.bridgelabz.cart.dto.CartDTO;

import lombok.Data;

@Data
@Entity
public class Cart {
	@Id
	@GeneratedValue
	private Integer cartID;
	private int userId;
	private int bookId;
	private int quantity;
	
	public Cart(Integer cartId, CartDTO dto) {
		super();
		this.cartID=cartId;
		this.userId = dto.getUserId();
		this.bookId = dto.getBookId();
		this.quantity = dto.getQuantity();
	}
	

	public Cart() {
		super();
	}
	


	public Cart(CartDTO dto) {
		this.userId = dto.getUserId();
		this.bookId = dto.getBookId();
		this.quantity = dto.getQuantity();
	}	
}
