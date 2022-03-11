package com.bridgelabz.order.dto;


import lombok.Data;

@Data
public class ResponseDTO {
 private String message;
 private Object order;
 
public ResponseDTO(String message, Object order) {
	super();
	this.message = message;
	this.order = order;
}

public ResponseDTO() {
	super();
}
 
}