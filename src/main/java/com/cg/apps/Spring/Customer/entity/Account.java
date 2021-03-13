package com.cg.apps.Spring.Customer.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue
	long accountID;
	double balance;
	LocalDateTime created;

	public Account() {
	}

	public Account(double balance, LocalDateTime created) {
		this.balance = balance;
		this.created = created;
	}

	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Account accountID=" + accountID + ", balance=" + balance + ", created=" + created;
	}
}
