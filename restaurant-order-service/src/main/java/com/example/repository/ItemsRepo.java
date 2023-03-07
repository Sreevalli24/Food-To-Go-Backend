package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Items;

@Repository
public interface ItemsRepo extends JpaRepository<Items, Integer> {
	
	public List<Items> findByName(String name);
	
	public List<Items> findByrestaurantId(Integer restaurantId);
	
	public Items getById(Integer itemId);
}