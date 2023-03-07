package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.exceptions.CartException;
import com.example.exceptions.ItemsException;
import com.example.model.Cart;
import com.example.model.Items;
import com.example.service.CartDaoImpl;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/cart")
public class CartController {
	
	@Autowired
	CartDaoImpl cartDAOimpl;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart) throws CartException{
		
		Cart newCart = cartDAOimpl.addCart(cart);
		return new ResponseEntity<Cart>(newCart, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/viewall", method = RequestMethod.GET)
	public ResponseEntity<?> getAllCartItems() throws CartException{
		
		List<Cart> cart = cartDAOimpl.viewAllCartItems();
		return ResponseEntity.status(HttpStatus.OK).body(cart);
	}
	
	@RequestMapping(value = "/view/{CartId}", method = RequestMethod.GET)
	public ResponseEntity<Cart> viewCart(@PathVariable Integer CartId) throws CartException{
		
		Cart cart = cartDAOimpl.viewCart(CartId);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{itemId}", method = RequestMethod.GET)
	public ResponseEntity<?> deleteCartItem(@PathVariable Integer itemId) throws CartException{
		
		Cart cart = cartDAOimpl.deleteCartItem(itemId);
		return ResponseEntity.status(HttpStatus.OK).body("Item removed from cart");
		
	}
}
