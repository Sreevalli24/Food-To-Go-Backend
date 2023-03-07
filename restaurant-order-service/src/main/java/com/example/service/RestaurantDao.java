package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.exceptions.RestaurantException;
import com.example.model.Restaurant;

@Service
public interface RestaurantDao {
	
	public Restaurant viewRestaurant(Integer restaurantId) throws RestaurantException;
	
    public List<Restaurant> searchRestaurantByName(String restaurantName) throws RestaurantException;
    
    public List<Restaurant> viewRestaurant() throws RestaurantException;

}