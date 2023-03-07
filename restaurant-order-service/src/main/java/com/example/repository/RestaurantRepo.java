package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Restaurant;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {
	
	@Query(value="select * from restaurant where restaurant_name = ?1", nativeQuery = true)
	public List<Restaurant> getByName(String restaurantName);
}
