package com.dao;

import java.util.List;
import com.entity.*;;
public interface Itemdao 

{
    List<Items> getAllItems();
    Items getItemsById(int oItems_id);
    void addItems(Items oItems);
    boolean Itemsexist(String name, String email);
    void updateItems(Items oItems);
    void deleteItems(int oItemsId);
} 