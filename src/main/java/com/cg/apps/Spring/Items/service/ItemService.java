package com.cg.apps.Spring.Items.service;
import java.time.LocalDateTime;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.apps.Spring.Items.dao.IItemDAO;
import com.cg.apps.Spring.Items.entity.Item;
@Service
public class ItemService implements IItemService {

	@Autowired
	IItemDAO itemDao;
	
	@Autowired
	EntityManager entityManager;
	
//	public String generateItemId() {
//		Random random = new Random();
//		Integer n = 1000000000 + random.nextInt(900000000);
//		String itemId = n.toString();
//		return itemId;
//	}

	@Transactional
	@Override
	public Item create(double price, String description) {
		LocalDateTime now = LocalDateTime.now();
		Item item = new Item( price, description, now);
		String id = item.generateID();
		while(entityManager.find(Item.class, id) != null) {
			id = item.generateID();
		}
		item.setItemId(id);
		itemDao.add(item);
		return item;
	}

	@Override
	public Item findById(String itemId) {
		Item item = itemDao.findById(itemId);
		return item;
	}

	@Override
	public Item buyItem(String itemId, Long customerId) {
		
		return null;
	}

	

}
