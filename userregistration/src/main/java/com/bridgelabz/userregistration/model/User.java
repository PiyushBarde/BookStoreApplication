package com.bridgelabz.userregistration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.bridgelabz.userregistration.dto.UserDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer UserId;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String password;
	
		
	public User(UserDTO dto) {
		this.firstName = dto.getFirstName();
		this.lastName = dto.getLastName();
		this.email = dto.getEmail();
		this.address = dto.getAddress();
		this.password = dto.getPassword();
	}
	
	 public User(Integer userId, UserDTO dto) {
			this.UserId = userId;
			this.firstName = dto.getFirstName();
			this.lastName = dto.getLastName();
			this.email = dto.getEmail();
			this.address = dto.getAddress();
			this.password = dto.getPassword();
	    }
	 
	public User() {
		super();
	}
}
