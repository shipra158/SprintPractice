package com.cg.apps.Spring.Customer.entity;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.cg.apps.Spring.Items.entity.Item;

@Entity
public class Customer {
	@GeneratedValue
	@Id
private	long id;
private	String name;

	@OneToOne
private	Account account;

	@OneToMany(fetch = FetchType.EAGER)
private	Set<Item> boughtItems;

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

	public Set<Item> getBoughtItems() {
		return boughtItems;
	}

	public void setBoughtItems(Set<Item> boughtItems) {
		this.boughtItems = boughtItems;
	}

	@Override
	public String toString() {
		return "Customer id=" + id + ", name=" + name + ", account=" + account;
	}
}
