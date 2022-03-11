package com.bridgelabz.cart.service;

import java.util.List;

import javax.validation.Valid;

import com.bridgelabz.cart.dto.CartDTO;
import com.bridgelabz.cart.dto.QuantityDTO;
import com.bridgelabz.cart.model.Cart;

public interface ICartService {
	

	Cart insertToCart(@Valid CartDTO dto);

	List<Cart> getAllCarts();

	Cart getCartByID(Integer cartId);

	Cart updateById(Integer cartId, @Valid CartDTO dto);

	Cart updateQuantity(QuantityDTO dto);
	
	Cart deleteById(Integer cartId);
}
