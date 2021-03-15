package com.cg.apps.Spring.Items.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.apps.Spring.Customer.entity.Customer;
import com.cg.apps.Spring.Items.entity.Item;
import com.cg.apps.Spring.Items.service.IItemService;

@Component
public class ItemUI {
	@Autowired
	IItemService service;
	public void start()
	{
		Item item1=service.create(250,"item1");
		display(item1);
		
		Item item2=service.create(620,"item2");
		display(item2);
	}
	public void display(Item Item) {
		System.out.println("Item "+Item. getItem()+" "+"Price"+" "+Item.getPrice()+" "+"Description"+Item.getDescription());
		
	}
	
	

}
