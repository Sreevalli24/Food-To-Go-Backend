package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.example.exceptions.RestaurantException;
import com.example.model.Restaurant;
import com.example.service.RestaurantDaoImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {
	
	@Autowired
	RestaurantDaoImpl restaurantDAOimpl;
	
	@RequestMapping(value = "/{restaurantName}", method = RequestMethod.GET)
	public ResponseEntity<?> findRestaurant(@PathVariable String restaurantName) throws RestaurantException {
		
		List<Restaurant> restaurant = restaurantDAOimpl.searchRestaurantByName(restaurantName);
		
		return ResponseEntity.status(HttpStatus.OK).body(restaurant);
	}
	
	@RequestMapping(value = "/view/{restaurantId}", method = RequestMethod.GET)
	public ResponseEntity<Restaurant> getByRestaurantId(@PathVariable Integer restaurantId) throws RestaurantException{
		
		Restaurant restaurant = restaurantDAOimpl.viewRestaurant(restaurantId);
		
		return new ResponseEntity<Restaurant>(restaurant ,HttpStatus.OK);
	}	
	
	@RequestMapping(value = "/viewall", method = RequestMethod.GET)
	public ResponseEntity<?> getRestaurant() throws RestaurantException{
		
		List<Restaurant> restaurants = restaurantDAOimpl.viewRestaurant();
		
		return ResponseEntity.status(HttpStatus.OK).body(restaurants);
	}
}