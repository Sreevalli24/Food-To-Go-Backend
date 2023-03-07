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

import com.example.exceptions.ItemsException;
import com.example.model.Items;
import com.example.service.ItemsDaoImpl;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/items")
public class ItemsController {
	
	@Autowired
	ItemsDaoImpl itemsDAOimpl;
	
	@RequestMapping(value = "/view/{itemId}", method = RequestMethod.GET)
	public ResponseEntity<Items> getItem(@PathVariable Integer itemId) throws ItemsException{
		
		Items items = itemsDAOimpl.viewItem(itemId);
		
		return new ResponseEntity<Items>(items, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/viewall", method = RequestMethod.GET)
	public ResponseEntity<?> getAllItems() throws ItemsException{
		
		List<Items> items = itemsDAOimpl.viewAllItems();
		
		return ResponseEntity.status(HttpStatus.OK).body(items);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Items> addItem(@RequestBody Items items) throws ItemsException{
		
		Items item = itemsDAOimpl.addItem(items);
		
		return new ResponseEntity<Items>(item, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> findItem(@PathVariable String name) throws ItemsException{
		
		List<Items> item = itemsDAOimpl.searchItem(name);
		
		return ResponseEntity.status(HttpStatus.OK).body(item);
	}	
	
	@RequestMapping(value = "/restaurant/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getItemByRestaurantId(@PathVariable Integer id) throws ItemsException{
		
		List<Items> items = itemsDAOimpl.getItems(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(items);
	}
	
	@RequestMapping(value = "/remove/{itemId}", method = RequestMethod.GET)
	public ResponseEntity<?> deleteItem(@PathVariable Integer itemId) throws ItemsException{
		
		Items item = itemsDAOimpl.deleteItem(itemId);
		
		return ResponseEntity.status(HttpStatus.OK).body("Item removed");
		
	}
	
	@RequestMapping(value = "/update/{itemId}", method = RequestMethod.POST)
	public ResponseEntity<?> updateItem(@PathVariable Integer itemId) throws ItemsException{
		
		Items item = itemsDAOimpl.viewItem(itemId);
		
		if(item.isAvailable()) {
			
			item.setAvailable(false);
		}
		
		else {
			
			item.setAvailable(true);
		}
		
		Items updatedItem = itemsDAOimpl.updateItem(item, itemId);
		
		return ResponseEntity.status(HttpStatus.OK).body(updatedItem);
	}
}
