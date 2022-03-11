package com.bridgelabz.cart.controller;

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

import com.bridgelabz.cart.dto.CartDTO;
import com.bridgelabz.cart.dto.QuantityDTO;
import com.bridgelabz.cart.dto.ResponseDTO;
import com.bridgelabz.cart.model.Cart;
import com.bridgelabz.cart.service.ICartService;


@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	ICartService service;
	
//	@GetMapping("/getuser/{id}")
//	public String callUserAndRetrieve(@PathVariable Integer id){
//		return service.callUserAndRetrieve(id);
//	}
//	
//	@GetMapping("/getuserobject/{id}")
//	public String callUserAndRetrieveObject(@PathVariable Integer id){
//		return service.callUserAndRetrieveObject(id);
//	}
	
	//to insert book in the cart
	@PostMapping("/insert")
	public ResponseEntity<ResponseDTO> insertBook(@Valid @RequestBody CartDTO dto){
		Cart cart = service.insertToCart(dto);
		ResponseDTO response = new ResponseDTO("Cart Added to bookstore", cart);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	//to get all carts in bookstore app
	@GetMapping("/getAll")
	public ResponseEntity<ResponseDTO> getAllCarts(){
		List<Cart> list = service.getAllCarts();
		ResponseDTO response = new ResponseDTO("All carts in bookstore",list );
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	//find cart by cart id
	@GetMapping("/findbyid/{cartId}")
	public ResponseEntity<ResponseDTO> getbookByID(@PathVariable Integer cartId){
		Cart cart = service.getCartByID(cartId);
		ResponseDTO response = new ResponseDTO("Requested Cart : ",cart);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	//update cart by cart id
	@PutMapping("/update/{cartId}")
	public ResponseEntity<ResponseDTO> updateById(@PathVariable  Integer cartId,@Valid @RequestBody CartDTO dto){
		Cart cart = service.updateById(cartId,dto);
		ResponseDTO response = new ResponseDTO("cart updated : ", cart);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	//update quantity of books using cart id
	@PutMapping("/updateQuantity")
	public ResponseEntity<ResponseDTO> updateQuantity(@RequestBody QuantityDTO dto){
		Cart cart = service.updateQuantity(dto);
		ResponseDTO response = new ResponseDTO("Quantity updated :", cart);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{cartId}")
	public ResponseEntity<ResponseDTO> deleteById(@PathVariable  Integer cartId){
		Cart cart = service.deleteById(cartId);
		ResponseDTO response = new ResponseDTO("cart deleted successfully",cart);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
}
