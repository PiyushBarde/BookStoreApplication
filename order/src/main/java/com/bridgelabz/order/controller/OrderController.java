package com.bridgelabz.order.controller;


import java.util.List;

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

import com.bridgelabz.order.dto.OrderDTO;
import com.bridgelabz.order.dto.ResponseDTO;
import com.bridgelabz.order.model.Order;
import com.bridgelabz.order.service.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	IOrderService service;
	
	@PostMapping("/insert")
	public ResponseEntity<ResponseDTO> addOrder(@RequestBody OrderDTO dto){
		Order order = service.addOrder(dto);
		ResponseDTO response = new ResponseDTO("Order Placed : ", order);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<ResponseDTO> getAll(){
		List<Order> list = service.getAll();
		ResponseDTO response = new ResponseDTO("Orders Placed : ", list);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
		
	}
	
	@GetMapping("/getById/{orderId}")
	public ResponseEntity<ResponseDTO> getById(@PathVariable Integer orderId){
		Order order = service.getByID(orderId);
		ResponseDTO response = new ResponseDTO("Order Retrieved : ", order);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
		
	}
	
	@PutMapping("/update/{orderId}")
	public ResponseEntity<ResponseDTO> updateById(@PathVariable Integer orderId,@RequestBody OrderDTO dto){
		Order order = service.updateById(orderId,dto);
		ResponseDTO response = new ResponseDTO("Order Updated : ", order);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);		
	}
	
	@DeleteMapping("/delete/{orderId}")
	public ResponseEntity<ResponseDTO> deleteById(@PathVariable Integer orderId){
		Order order = service.deleteById(orderId);
		ResponseDTO response = new ResponseDTO("Order deleted : ", order);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);		
	}
	
	
	
//	@GetMapping("/user/{id}")
//	public ResponseEntity<ResponseDTO> practice(@PathVariable Integer id){
//		User user = service.insertOrder(id);
//		ResponseDTO response = new ResponseDTO("Order Added : ", user);
//		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
//	}
}
