package com.bridgelabz.userregistration.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UserDTO {	
	@Pattern(regexp = "^[A-Z]{1}[a-z A-Z]{2,}",message = "invalid first name first word must be capital")
	private String firstName;
	@Pattern(regexp = "^[A-Z]{1}[a-z A-Z]{2,}",message = "invalid last name first word must be capital")
	private String lastName;
	@Email
	private String email;
	@NotEmpty(message = "address must be filled")
	private String address;
	@NotEmpty(message = "address must be filled")
	private String password;
	
	public UserDTO() {
		super();
	}
}
