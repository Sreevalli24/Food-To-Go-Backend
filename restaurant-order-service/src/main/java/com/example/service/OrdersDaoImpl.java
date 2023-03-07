package com.example.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.ItemsException;
import com.example.exceptions.OrdersException;
import com.example.model.Orders;
import com.example.repository.OrdersRepo;

@Service
public class OrdersDaoImpl implements OrdersDao{
	
	@Autowired
	OrdersRepo ordersrepo;

	@Override
	public Orders addOrder(Orders order) throws OrdersException{
		
		if (order.getOrderStatus().isEmpty()) {
			
			throw new OrdersException("Input Field Is Empty..");
		}

		return ordersrepo.save(order);
	}

	@Override
	public Orders viewOrder(Integer orderId) throws OrdersException{
		
		Optional<Orders> order = ordersrepo.findById(orderId);
		
		if(order.isPresent()) {
			
			return order.get();
			
		}else {
			
			throw new OrdersException("No Order found with ID : " + orderId);
		}
	}

	@Override
	public Orders updateOrder(Orders orders, Integer orderId) throws OrdersException{
		
		Optional<Orders> order = ordersrepo.findById(orderId);
		
		if(order.isPresent()) {
			
			return ordersrepo.save(orders);
			
		}else {
			
			throw new OrdersException("No such Order found..");
		}
	}	
}

