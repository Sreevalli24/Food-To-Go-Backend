package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.exceptions.ItemsException;
import com.example.exceptions.OrdersException;
import com.example.model.Items;
import com.example.model.Orders;
import com.example.service.OrdersDaoImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orders")
public class OrdersController {
	
	@Autowired
	OrdersDaoImpl ordersDAOimpl;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Orders> addOrder(@RequestBody Orders orders) throws OrdersException{
		
		Orders order = ordersDAOimpl.addOrder(orders);
		
		return new ResponseEntity<Orders>(order, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/view/{orderId}", method = RequestMethod.GET)
	public ResponseEntity<Orders> viewOrder(@PathVariable Integer orderId) throws OrdersException{
		
		Orders order = ordersDAOimpl.viewOrder(orderId);
		
		return new ResponseEntity<Orders>(order, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update/{orderId}", method = RequestMethod.POST)
	public ResponseEntity<?> updateOrder(@PathVariable Integer orderId) throws OrdersException{
		
		Orders newOrder = ordersDAOimpl.viewOrder(orderId);
		
		newOrder.setOrderStatus("delivered");
		
		Orders updatedOrder = ordersDAOimpl.updateOrder(newOrder, orderId);
		
		return ResponseEntity.status(HttpStatus.OK).body(updatedOrder);
	}
	
	@RequestMapping(value = "/byrestaurant/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getOrdersByRestaurantId(@PathVariable Integer id) throws OrdersException{
		
		List<Orders> orders = ordersDAOimpl.getOrders(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(orders);
	}
	
	@RequestMapping(value = "/viewall", method = RequestMethod.GET)
    public ResponseEntity<?> getAllOrders() throws OrdersException{
		
		List<Orders> orders = ordersDAOimpl.viewAllOrders();
		
		return ResponseEntity.status(HttpStatus.OK).body(orders);
	}
}
