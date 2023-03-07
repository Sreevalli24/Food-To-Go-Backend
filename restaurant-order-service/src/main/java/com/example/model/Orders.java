package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId")
	private Integer id;
	
	private String orderStatus;
	
	@ManyToOne
    @JoinColumn(name="restaurantId")
    private Restaurant restaurant;
	
	@ManyToOne
    @JoinColumn(name="itemId")
	private Items items;
	
	public Integer getId() {
		
		return id;
	}
	public void setId(Integer id) {
		
		this.id = id;
	}
	public String getOrderStatus() {
		
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		
		this.orderStatus = orderStatus;
	}
	
	public Restaurant getRestaurant() {
		
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		
		this.restaurant = restaurant;
	}
	
	public Items getItems() {
		
		return items;
	}
	public void setItems(Items items) {
		
		this.items = items;
	}	
}