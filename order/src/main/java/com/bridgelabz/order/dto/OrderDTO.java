package com.bridgelabz.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDTO {
	
	private Integer userId;
	private Integer bookId;
	private Integer quantity;
	private String address;
	private boolean cancel;
	
}
