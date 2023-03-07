package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.exceptions.ItemsException;
import com.example.model.Items;

@Service
public interface ItemsDao {

	public Items addItem(Items items) throws ItemsException;
	
	public Items viewItem(Integer itemId) throws ItemsException;
	
	public List<Items> searchItem(String name) throws ItemsException;
	
	public List<Items> viewAllItems() throws ItemsException;
	
	public List<Items> getItems(Integer id) throws ItemsException;
	
	public Items deleteItem(Integer itemId) throws ItemsException;
	
	public Items updateItem(Items items , Integer itemId) throws ItemsException;
}
