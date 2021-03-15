package com.cg.apps.Spring.Items.service;

import com.cg.apps.Spring.Items.entity.Item;

public interface IItemService  {
	
	Item create(double price, String description);
	Item findById(String itemId);
	Item buyItem(String itemId, Long customerId);


}
