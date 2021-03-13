package com.cg.apps.Spring.Customer.dao;

import com.cg.apps.Spring.Customer.entity.Customer;

public interface ICustomerDAO {

	Customer add(Customer customer);
	Customer findById(Long customerId);
	Customer update(Customer customer);

}
