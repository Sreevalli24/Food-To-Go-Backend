package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.Orders;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Integer> {
	
	public Orders getOrderById(Integer orderId);
	
	public List<Orders> findByRestaurantId(Integer restaurantId);
}
