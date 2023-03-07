package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	
	private String quantity;
	
	@ManyToOne
	@JoinColumn(name = "itemId")
	private Items items;

	
	public Integer getCartId() {
		
		return cartId;
	}

	public void setCartId(Integer cartId) {
		
		this.cartId = cartId;
	}

	public String getQuantity() {
		
		return quantity;
	}

	public void setQuantity(String quantity) {
		
		this.quantity = quantity;
	}

	public Items getItems() {
		
		return items;
	}

	public void setItems(Items items) {
		
		this.items = items;
	}
}
