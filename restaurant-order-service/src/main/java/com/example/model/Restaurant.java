package com.example.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "restaurantId")
	private Integer id;
	
	private String imageUrl;
	
	private String restaurantName;
	
	public Integer getId() {
		
		return id;
	}

	public void setId(Integer id) {
		
		this.id = id;
	}

	public String getRestaurantName() {
		
		return restaurantName;
	}
	
	public void setRestaurantName(String restaurantName) {
		
		this.restaurantName = restaurantName;
	}

	public String getImageUrl() {
		
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		
		this.imageUrl = imageUrl;
	}
}