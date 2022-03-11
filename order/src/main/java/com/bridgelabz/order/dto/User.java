package com.bridgelabz.order.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class User {
	
	private Integer UserId;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String password;
	
		
	public User(User user) {
		this.UserId=user.UserId;
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.address = user.getAddress();
		this.password = user.getPassword();
	}

	 
	public User() {
		super();
	}
}
