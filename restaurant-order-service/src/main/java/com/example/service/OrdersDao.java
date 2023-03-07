package com.example.service;

import org.springframework.stereotype.Service;

import com.example.exceptions.OrdersException;
import com.example.model.Orders;

@Service
public interface OrdersDao {

	public Orders addOrder(Orders order) throws OrdersException;
	
	public Orders viewOrder(Integer orderId) throws OrdersException;
	
	public Orders updateOrder(Orders orders , Integer orderId) throws OrdersException;
}