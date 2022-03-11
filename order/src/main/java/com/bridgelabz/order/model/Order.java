package com.bridgelabz.order.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.order.dto.OrderDTO;

import lombok.Data;


@Data
@Entity
@Table(name="order_details")
public class Order {
	@Id
	@GeneratedValue
	private Integer orderID;
	private LocalDate date = LocalDate.now();
	private Integer price;
	private Integer quantity;
	private String address;
	private Integer userId;
	private Integer bookId;
	private boolean cancel;
	
	
	public Order() {
		super();
	}


	public Order(OrderDTO dto) {
		super();
		this.quantity = dto.getQuantity();
		this.address = dto.getAddress();
		this.userId = dto.getUserId();
		this.bookId = dto.getBookId();
		this.cancel = dto.isCancel();
	}
	
}
