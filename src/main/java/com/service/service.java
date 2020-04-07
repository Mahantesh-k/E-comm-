package com.service;

import java.util.List;

import com.entity.Items;
public interface service 
{
	 List<Items> getAllItems();
	 Items getItemsById(int oItemsId);
	 boolean addItems(Items oItems);
	 void updateItems(Items oItems);
	 void deleteItems(int oItemsId);
}
