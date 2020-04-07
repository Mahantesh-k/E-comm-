package com.service;

import java.util.List;

import com.entity.Items;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.Itemdao;

@Service
public class SeviceImpl implements service {

	@Autowired
	private Itemdao oItemdao;
	
	
	@Override
	public List<Items> getAllItems()
	{
		return oItemdao.getAllItems();
	}
	

	@Override
	public Items getItemsById(int oItemsId) {
		
		Items obj = oItemdao.getItemsById(oItemsId);
			return obj;
	}

	@Override
	public boolean addItems(Items oItems) {
		
            if (oItemdao.Itemsexist(oItems.getEmail(),oItems.getItems_name())) 
            {
	            return false;
            } else {
            	oItemdao.addItems(oItems);
	            return true;
            }
	}

	@Override
	public void updateItems(Items oItems) 
	{
		oItemdao.updateItems(oItems);
	}

	@Override
	public void deleteItems(int oItemsId) {
		
		oItemdao.deleteItems(oItemsId);
		
	}

}
