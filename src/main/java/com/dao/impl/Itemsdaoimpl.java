package com.dao.impl;



import java.util.List;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Itemdao;
import com.entity.Items;

@Transactional
@Repository

public class Itemsdaoimpl implements Itemdao 
{

	@PersistenceContext	
	private EntityManager entityManager;	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Items> getAllItems() 
	{
		String hql = "FROM Items as atcl ORDER BY atcl.ItemsId";
		return (List<Items>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Items getItemsById(int oItemsId) 
	{
		return entityManager.find(Items.class, oItemsId);
	}
	
	@Override
	public boolean Itemsexist(String name, String email) 
	{
		String hql = "FROM Items as atcl WHERE atcl.name = ? and atcl.email = ?";
		int count = entityManager.createQuery(hql).setParameter(1, name)
		              .setParameter(2, email).getResultList().size();
		return count > 0 ? true : false;
	}

	@Override
	public void updateItems(Items oItems) 
	{
		Items items = getItemsById(oItems.getItems_id());
		items.setEmail(oItems.getEmail());
		items.setItems_name(oItems.getItems_name());
		entityManager.flush();
		
	}

	@Override
	public void deleteItems(int oItemsId) 
	{
		entityManager.remove(getItemsById(oItemsId));
		
	}

	@Override
	public void addItems(Items oItems) {
		entityManager.persist(oItems);
		
	}

}
