package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.CartException;
import com.example.exceptions.ItemsException;
import com.example.model.Cart;
import com.example.model.Items;
import com.example.repository.CartRepo;

@Service
public class CartDaoImpl implements CartDao{
	
	@Autowired
	CartRepo cartRepo;

	@Override
	public Cart addCart(Cart cart) throws CartException{
		
		if (cart.getQuantity().isEmpty()) {
			
			throw new CartException("Input Field Is Empty..");
		}
		
		return cartRepo.save(cart);
		
	}

	@Override
	public Cart viewCart(Integer cartId) throws CartException{
		
		Optional<Cart> cart = cartRepo.findById(cartId);
		
		if(cart.isPresent()) {
			
			return cart.get();
			
		}else {
			
			throw new CartException("No Cart found with ID : " + cartId);
		}
	}

	@Override
	public Cart deleteCartItem(Integer itemId) throws CartException{
		
		Optional<Cart> item = cartRepo.findById(itemId);
		
		if(item.isPresent()) {
			
			Cart cart = item.get();
			
			cartRepo.deleteById(itemId);
			
			return cart;
			
		}else {
			
			throw new CartException("No Item found in cart with ID : " + itemId);
		}	
		
	}

	@Override
    public List<Cart> viewAllCartItems() throws CartException{
		
		List<Cart> cart = cartRepo.findAll();
		
		if(cart.size() > 0) {
			
			return cart;
			
		}else {
			
			throw new CartException("No Item exists in cart..");
		}		
	}
}
