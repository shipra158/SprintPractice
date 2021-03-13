package com.cg.apps.Spring.Customer.service;

import java.util.List;

import com.cg.apps.Spring.Customer.entity.Customer;



 public interface ICustomerService {

		Customer findById(Long customerId);
		Customer createCustomer(String name);	
		Customer addAmount(Long customerId, double amount);
}
