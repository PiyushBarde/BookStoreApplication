package com.bridgelabz.userregistration.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.userregistration.dto.LoginDTO;
import com.bridgelabz.userregistration.dto.ResponseDTO;
import com.bridgelabz.userregistration.dto.UserDTO;
import com.bridgelabz.userregistration.model.User;
import com.bridgelabz.userregistration.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserService service;
	
	//to register user in bookstore app
	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> registerUser(@Valid @RequestBody UserDTO dto){
		User user = service.registerUserToDB(dto);
		ResponseDTO response = new ResponseDTO("User Registered to bookstore", user);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	//to login in book store app
	@GetMapping("/login")
	public ResponseEntity<ResponseDTO> loginUser(@Valid @RequestBody LoginDTO dto){
		ResponseDTO response = new ResponseDTO("User Login :", service.loginUser(dto));
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	//to reset password of user
	@PutMapping("/resetpassword")
	public ResponseEntity<ResponseDTO> changePassword(@Valid @RequestBody UserDTO dto){
		ResponseDTO response = new ResponseDTO("User Login :", service.changePassword(dto));
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	//to find user using token
	@GetMapping("/findbyid/{token}")
	public ResponseEntity<ResponseDTO> getById(@PathVariable String token){
		User user =  service.getUserByID(token);
		ResponseDTO response = new ResponseDTO("Requested User : ", user);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	//to get user by email
	@GetMapping("/findbyemail/{email}")
	public ResponseEntity<ResponseDTO> getByEmail(@PathVariable String email){
		User user =  service.getUserByEmail(email);
		ResponseDTO response = new ResponseDTO("Requested User : ", user);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	//to get list of users using a global key
	@GetMapping("/getall")
	public ResponseEntity<String>retrieveUsers(){
		List<User> user = service.retrieveUsers();
		ResponseDTO response = new ResponseDTO("Users :", user);
		return new ResponseEntity(response,HttpStatus.OK);
	}

	//to update the User through token (using .findByUserId & .isPresent)
	@PutMapping("/update/{token}")
	public ResponseEntity<ResponseDTO> updateById(@PathVariable  String token,@Valid @RequestBody UserDTO dto){
		User user = service.updateById(token,dto);
		ResponseDTO response = new ResponseDTO("User updated : ", user);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}

	//to delete user(using .findByUserId & .isEmpty)
	@DeleteMapping("/delete/token")
	public ResponseEntity<ResponseDTO> deleteById(@PathVariable String token){
		ResponseDTO response = new ResponseDTO("User deleted successfully",service.deleteById(token));
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	//--------------------API Calls for RestTemplate----------------------------//
	
	@GetMapping("/findById/{userId}")
	public User getByIdAPI(@PathVariable Integer userId){
		User user =  service.getByIdAPI(userId);		
		return user;
	}
	
}
