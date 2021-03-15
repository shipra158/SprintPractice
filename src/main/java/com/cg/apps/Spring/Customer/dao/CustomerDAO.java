package com.cg.apps.Spring.Customer.dao;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.apps.Spring.Customer.entity.Account;
import com.cg.apps.Spring.Customer.entity.Customer;



@Repository

public class CustomerDAO implements ICustomerDAO{
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Transactional
	@Override
	public Customer add(Customer customer)
	{
		LocalDateTime now = LocalDateTime.now();
		Account account = customer.getAccount();
		account.setCreated(now);
		entityManager.persist(account);
		entityManager.persist(customer);   //adding customer
		return customer;
	}
	
	@Override
   
	public Customer findById(Long customerId)     //finding customer
	{
	Customer customer=entityManager.find(Customer.class, customerId);
		return customer;
	}
	
	@Transactional
	@Override
	public Customer update(Customer customer)        //update customer
	{
		entityManager.merge(customer);
		return customer;
	}

}
