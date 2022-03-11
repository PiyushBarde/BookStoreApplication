package com.bridgelabz.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.cart.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{

}
