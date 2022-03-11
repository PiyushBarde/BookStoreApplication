package com.bridgelabz.book.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.bridgelabz.book.dto.BookDTO;

import lombok.Data;

@Data
@Entity
public class Book {
	@Id
	@GeneratedValue
	private Integer bookId;
	private String authoreName;
	private String bookName;
	private String bookImg;
	private int price;
	private int quantity;
	
	
	public Book(BookDTO dto) {
		super();
		this.authoreName = dto.getAuthoreName();
		this.bookName = dto.getBookName();
		this.bookImg = dto.getBookImg();
		this.price = dto.getPrice();
		this.quantity = dto.getQuantity();
	}
	
	public Book(Integer bookId,BookDTO dto) {
		super();
		this.bookId=bookId;
		this.authoreName = dto.getAuthoreName();
		this.bookName = dto.getBookName();
		this.bookImg = dto.getBookImg();
		this.price = dto.getPrice();
		this.quantity = dto.getQuantity();
	}

	public Book() {
		super();
	}
	
}
