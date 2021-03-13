package com.cg.apps.Spring.Customer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@GeneratedValue
	@Id
	long id;
	String name;

	@OneToOne
	Account account;

	public Customer() {
	}

	public Customer(String name, Account account) {
		this.name = name;
		this.account = account;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}


	@Override
	public String toString() {
		return "Customer id=" + id + ", name=" + name + ", account=" + account;
	}
}
