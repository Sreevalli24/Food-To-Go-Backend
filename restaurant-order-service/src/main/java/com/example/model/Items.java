package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Items {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer itemId;
	
	private String name;
	
	private Double price;
	
	private String imageUrl;
	
    private boolean available;
    
    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;
    
	public Integer getItemId() {
		
		return itemId;
	}

	public void setItemId(Integer itemId) {
		
		this.itemId = itemId;
	}

	public String getName() {
		
		return name;
	}
    
	public void setName(String name) {
		
		this.name = name;
	}

	public Double getPrice() {
		
		return price;
	}

	public void setPrice(Double price) {
		
		this.price = price;
	}

	public String getImageUrl() {
		
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		
		this.imageUrl = imageUrl;
	}

	public boolean isAvailable() {
		
		return available;
	}

	public void setAvailable(boolean available) {
		
		this.available = available;
	} 
	
	
	public Restaurant getRestaurant() {
		
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		
		this.restaurant = restaurant;
	}

}
