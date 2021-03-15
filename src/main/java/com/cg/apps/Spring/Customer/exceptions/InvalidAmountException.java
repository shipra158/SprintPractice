package com.cg.apps.Spring.Customer.exceptions;

public class InvalidAmountException extends RuntimeException {
	public InvalidAmountException(String msg) {
		super(msg);
	}

}
