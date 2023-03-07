package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.RestaurantException;
import com.example.model.Restaurant;
import com.example.repository.RestaurantRepo;

@Service
public class RestaurantDaoImpl implements RestaurantDao {
	
	@Autowired
	RestaurantRepo restaurantRepo;

	@Override
	public Restaurant viewRestaurant(Integer restaurantId) throws RestaurantException {
		
		 Optional<Restaurant> restaurant = restaurantRepo.findById(restaurantId);
		 
		 if(restaurant.isPresent()) {
			 
			 Restaurant restaurants = restaurant.get();
			 
			 return restaurants;
			 
		 } else {
			 
			 throw new RestaurantException("No Restaurant found with ID : " +restaurantId);
		}
	}


	@Override
	public List<Restaurant> searchRestaurantByName(String restaurantName) throws RestaurantException{
		
		List<Restaurant> restaurant = restaurantRepo.getByName(restaurantName);
		
		if(restaurant.isEmpty()) {
			
			throw new RestaurantException("No Restaurant Found With Name : " +restaurantName);
		}
		
	    return restaurant;
	}
	
	@Override
	public List<Restaurant> viewRestaurant() throws RestaurantException {
		
		List<Restaurant> restaurant = restaurantRepo.findAll();
		
		if (restaurant.isEmpty()) {
			
			throw new RestaurantException("Hey Restaurant List Is Empty..");
		}
		
		return restaurant;	
	}

}
