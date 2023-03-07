package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.exceptions.CartException;
import com.example.exceptions.ItemsException;
import com.example.model.Cart;
import com.example.model.Items;

@Service
public interface CartDao {
	
	public Cart addCart(Cart cart) throws CartException;
	
	public Cart viewCart(Integer cartId) throws CartException;
	
	public Cart deleteCartItem(Integer itemId) throws CartException;
	
	public List<Cart> viewAllCartItems() throws CartException;
}
