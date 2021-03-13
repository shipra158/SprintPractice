package com.cg.apps.Spring.Customer.ui;

import java.io.InvalidClassException;
import java.security.cert.CertStoreException;
import java.util.Collection;
import java.util.List;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.cg.apps.Spring.Customer.entity.Account;
import com.cg.apps.Spring.Customer.entity.Customer;
import com.cg.apps.Spring.Customer.service.ICustomerService;



@Component
public class CustomerUI {
	
	@Autowired
	ICustomerService service;

	
	public void start() {
		
		Customer Radha = service.createCustomer("Radha");
		display(Radha);
		
		Customer Sakshi = service.createCustomer("Sakshi");
		display(Sakshi);
		
		Long id=Radha.getId();
		Customer findCustomer = service.findById(id);
		display(findCustomer);
		
		Customer RadhaAmount=service.addAmount(id, 1000);
		display(RadhaAmount);
	}	
	
	
	 public void display(Customer customer) {
		Account account = customer.getAccount();
		System.out.println("Customer "+customer.getId()+"Name"+" "+customer.getName()+" "+customer.getAccount());
	}
}
	