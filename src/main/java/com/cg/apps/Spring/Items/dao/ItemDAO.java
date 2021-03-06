package com.cg.apps.Spring.Items.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.apps.Spring.Items.entity.Item;

@Repository
public class ItemDAO implements IItemDAO {
	
	@Autowired
	EntityManager entityManager;

	@Transactional
	@Override
	public Item add(Item item) {
		entityManager.persist(item);
		return item;
	}

	@Transactional
	@Override
	public Item update(Item item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public Item findById(String itemId) {
		Item item = entityManager.find(Item.class, itemId);
		return item;
	}
	
}
