package com.exception.banktransactionsystem;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends Exception {
	String message;

	public InsufficientBalanceException(String message) {
		super(message);
		
	}
	
}
