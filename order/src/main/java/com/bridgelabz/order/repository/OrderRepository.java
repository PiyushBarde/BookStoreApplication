package com.bridgelabz.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
