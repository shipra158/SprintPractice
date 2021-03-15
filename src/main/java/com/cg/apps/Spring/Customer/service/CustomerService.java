package com.cg.apps.Spring.Customer.service;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cg.apps.Spring.Customer.dao.ICustomerDAO;
import com.cg.apps.Spring.Customer.entity.Account;
import com.cg.apps.Spring.Customer.entity.Customer;
import com.cg.apps.Spring.Customer.exceptions.InvalidAmountException;
import com.cg.apps.Spring.Customer.exceptions.InvalidCustomerNameException;
import com.cg.apps.Spring.Items.entity.Item;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	ICustomerDAO dao;

	@Autowired
	EntityManager entityManager;

	private Long customerId;

	@Transactional
	@Override
	public Customer createCustomer(String name) {
		LocalDateTime now = LocalDateTime.now();
		Account account = new Account(0, now);
		entityManager.persist(account);
		Customer customer = new Customer(name, account);
		dao.add(customer);
		return customer;
	}

	@Override
	public Customer findById(Long customerId) {
		Customer customer = dao.findById(customerId);
		return customer;
	}

	@Transactional
	@Override
	public Customer addAmount(Long customerId, double amount) {
		Customer customer = dao.findById(customerId);
		customer.getAccount().setBalance(amount);
		customer = dao.update(customer);
		return customer;
	}

	@Transactional
	@Override

	public Set<Item> itemsBoughtByCustomer(Long customerId1) {
		Customer customer = dao.findById(customerId);
		Set<Item> itemSet = customer.getBoughtItems();
		return itemSet;
	}

	public void validateName(String name) {
		if (name == null || name.isEmpty()) {
			throw new InvalidCustomerNameException("Name cannot be null or empty");
		}
	}

	public void validateAmount(double amount) {
		if (amount < 0) {
			throw new InvalidAmountException("Amount cannot be less than 0");
		}

	}
}
