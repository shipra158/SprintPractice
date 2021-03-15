package com.cg.apps.Spring.Customer.service;

import java.util.List;
import java.util.Set;

import com.cg.apps.Spring.Customer.entity.Customer;
import com.cg.apps.Spring.Items.entity.Item;



 public interface ICustomerService {

		Customer findById(Long customerId);
		Customer createCustomer(String name);	
		Customer addAmount(Long customerId, double amount);
		Set<Item> itemsBoughtByCustomer(Long customerId);
}
