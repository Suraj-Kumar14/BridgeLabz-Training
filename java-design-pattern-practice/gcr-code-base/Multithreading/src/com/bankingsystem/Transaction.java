package com.bankingsystem;

import java.time.LocalTime;

public class Transaction implements Runnable{

	private BankAccount account;
	private int amount;
	private String customerName;
	
	
	public Transaction(BankAccount account, int amount, String customerName) {
		this.account = account;
		this.amount = amount;
		this.customerName = customerName;
	}


	@Override
	public void run() {
		System.out.println("Thread state before execution ["+Thread.currentThread().getName()+"]: "+Thread.currentThread().getState());
		
		System.out.println("Time: "+LocalTime.now());
		
		account.withdraw(amount, customerName);
		
	}

}
