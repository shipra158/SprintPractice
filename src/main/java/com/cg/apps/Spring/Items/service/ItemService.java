package com.cg.apps.Spring.Items.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.Spring.Customer.dao.CustomerDAO;
import com.cg.apps.Spring.Customer.dao.ICustomerDAO;
import com.cg.apps.Spring.Customer.entity.Customer;
import com.cg.apps.Spring.Customer.exceptions.InvalidPriceException;
import com.cg.apps.Spring.Items.dao.IItemDAO;
import com.cg.apps.Spring.Items.entity.Item;

@Service
public class ItemService implements IItemService {

	@Autowired
	IItemDAO itemDao;
	@Autowired
	ICustomerDAO customerDao;
	@Autowired
	EntityManager entityManager;

	@Transactional
	@Override
	public Item create(double price, String description) {
		LocalDateTime now = LocalDateTime.now();
		Item item = new Item(price, description, now);
		String id = item.generateID();
		while (entityManager.find(Item.class, id) != null) {
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

	@Transactional
	@Override
	public Item buyItem(String itemId, Long customerId) {
		Item item = itemDao.findById(itemId);
		Customer customer = customerDao.findById(customerId);
		item.setBoughtBy(customer);
		itemDao.update(item);
		Set<Item> items = customer.getBoughtItems();
		if (items == null) {
			items = new HashSet<>();
			customer.setBoughtItems(items);
		}
		items.add(item);
		customerDao.update(customer);
		return item;
	}

}
