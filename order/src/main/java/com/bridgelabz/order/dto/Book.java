package com.bridgelabz.order.dto;

import lombok.Data;

@Data
public class Book {

	private Integer bookId;
	private String authoreName;
	private String bookName;
	private String bookImg;
	private int price;
	private int quantity;
	
	
	public Book(Book book) {
		super();
		this.bookId = book.getBookId();
		this.authoreName = book.getAuthoreName();
		this.bookName = book.getBookName();
		this.bookImg = book.getBookImg();
		this.price = book.getPrice();
		this.quantity = book.getQuantity();
	}
	
	public Book() {
		super();
	}
	
}
