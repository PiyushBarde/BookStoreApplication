package com.bridgelabz.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
	private String authoreName;
	private String bookName;
	private String bookImg;
	private int price;
	private int quantity;
}
