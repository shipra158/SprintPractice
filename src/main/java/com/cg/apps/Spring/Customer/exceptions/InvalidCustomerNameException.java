package com.cg.apps.Spring.Customer.exceptions;

public class InvalidCustomerNameException extends RuntimeException {

	public InvalidCustomerNameException(String msg) {
		super(msg);
	}
}
