package com.bridgelabz.cart.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bridgelabz.cart.dto.CartDTO;
import com.bridgelabz.cart.dto.QuantityDTO;
import com.bridgelabz.cart.exceptions.CartException;
import com.bridgelabz.cart.model.Cart;
import com.bridgelabz.cart.repository.CartRepository;

@Service
public class CartService implements ICartService{
	
	@Autowired
	CartRepository repo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	//to insert items in cart
	@Override
	public Cart insertToCart(@Valid CartDTO dto) {
		Cart cart = new Cart(dto);
		repo.save(cart);
		return cart;
	}
	
	//to get all carts in bookstore app
	@Override
	public List<Cart> getAllCarts() {
		List<Cart> list = repo.findAll();
		if(list.isEmpty()) {
			throw new NullPointerException("there are no Carts inserted yet");
		}
		return list;
	}
	
	//find cart by cart id
	@Override
	public Cart getCartByID(Integer cartId) {
		Optional<Cart> cart = repo.findById(cartId);
		if(cart.isEmpty()) {
			throw new CartException("There are no carts with given id");
		}
		return cart.get();
	}
	
	//update cart by cart id
	@Override
	public Cart updateById(Integer cartId, @Valid CartDTO dto) {
		Optional<Cart> cart = repo.findById(cartId);
		if(cart.isPresent()) {
			Cart newCart = new Cart(cartId,dto);
			repo.save(newCart);
			return newCart;
		}
		else {
			throw new CartException("cart not found");
		}
	}
	
	//update quantity of books using cart id
	@Override
	public Cart updateQuantity(QuantityDTO dto) {
		Optional<Cart> cart = repo.findById(dto.getCartID());
		if(cart.isEmpty()) {
			throw new CartException("Invalid CartID..please input valid Id");
		}
		cart.get().setQuantity(dto.getQuantity());
		repo.save(cart.get());
		return cart.get();
	}

	@Override
	public Cart deleteById(Integer cartId) {
		Optional<Cart> cart = repo.findById(cartId);
		if(cart.isEmpty()) {
			throw new CartException("Invalid CartID..please input valid Id");
		}
		repo.deleteById(cartId);
		return cart.get();
	}
	
	
	


//	public String callUserAndRetrieve(Integer Userid) {
//		return restTemplate.getForObject("http://localhost:8080/user/findbyid/"+Userid, String.class);
//	}
//	
//	public UserModel callUserAndRetrieveObject(Integer Userid) {
//		UserModel user = restTemplate.getForObject("http://localhost:8080/user/findbyid/"+Userid, UserModel.class);
//		return user;
//	}
}


