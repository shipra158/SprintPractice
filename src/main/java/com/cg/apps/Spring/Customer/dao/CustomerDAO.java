package com.cg.apps.Spring.Customer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.apps.Spring.Customer.entity.Customer;



@Repository

public class CustomerDAO implements ICustomerDAO{
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Transactional
	@Override
	public Customer add(Customer customer)
	{
		
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
	//update customer
	public Customer update(Customer customer)        //update customer
	{
		entityManager.merge(customer);
		return customer;
	}

}
