package com.bridgelabz.order.service;

import java.util.List;

import com.bridgelabz.order.dto.OrderDTO;
import com.bridgelabz.order.model.Order;


public interface IOrderService{

//	public User insertOrder(Integer id);

	 Order addOrder(OrderDTO dto);

	Order getByID(Integer orderId);

	List<Order> getAll();

	Order updateById(Integer orderId,OrderDTO dto);

	Order deleteById(Integer orderId);

}
