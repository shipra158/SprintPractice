package com.cg.apps.Spring.Items.dao;

import com.cg.apps.Spring.Items.entity.Item;

public interface IItemDAO {
	
	Item add(Item item);
	Item update(Item item);
	Item findById(String itemId);
	
	
	

}
