package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.ItemsException;
import com.example.exceptions.RestaurantException;
import com.example.model.Items;
import com.example.repository.ItemsRepo;

@Service
public class ItemsDaoImpl implements ItemsDao {
	
	@Autowired
	ItemsRepo itemsRepo;

	@Override
	public Items addItem(Items items) throws ItemsException{
		
		if (items.getName().isEmpty()) {
			
			throw new ItemsException("Input Fields Are Empty..");
		}

		return itemsRepo.save(items);
	}

	@Override
	public Items viewItem(Integer itemId) throws ItemsException{
		
		Optional<Items> item = itemsRepo.findById(itemId);
		
		if(item.isPresent()) {
			
			return item.get();
			
		}else {
			
			throw new ItemsException("No Item found with ID : " + itemId);
		}
	}

	@Override
	public List<Items> searchItem(String name) throws ItemsException{
		
		List<Items> item = itemsRepo.findByName(name);
		
        if(item.isEmpty()) {
			
			throw new ItemsException("No Item Found With Name : " +name);
		}
        
		return item; 
	}

	@Override
	public List<Items> viewAllItems() throws ItemsException{
		
		List<Items> items = itemsRepo.findAll();
		
		if(items.size() > 0) {
			
			return items;
			
		}else {
			
			throw new ItemsException("No Item exists..");
		}
		
	}

	@Override
	public List<Items> getItems(Integer id) throws ItemsException{
		
		List<Items> items = itemsRepo.findByrestaurantId(id);
		
		if(items.isEmpty()) {
			
			throw new ItemsException("No Items Available..");

		}
		
		return items;
	}

	@Override
	public Items deleteItem(Integer itemId) throws ItemsException{
		
		Optional<Items> item = itemsRepo.findById(itemId);
		
		if(item.isPresent()) {
			
			Items items = item.get();
			
			itemsRepo.delete(items);
			
			return items;
			
		}else {
			
			throw new ItemsException("No Item found with ID : " + itemId);
			
		}	
	}

	@Override
	public Items updateItem(Items items, Integer itemId) throws ItemsException{
		
		Optional<Items> item = itemsRepo.findById(itemId);
		
		if(item.isPresent()) {
			
			return itemsRepo.save(items);
			
		}else {
			
			throw new ItemsException("No such Item found..");
			
		}
	}	
}