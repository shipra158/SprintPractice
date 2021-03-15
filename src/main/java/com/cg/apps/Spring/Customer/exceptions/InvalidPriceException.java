package com.cg.apps.Spring.Customer.exceptions;

public class InvalidPriceException extends RuntimeException {
	public InvalidPriceException(String msg)
	{
		super(msg);
	}

}
