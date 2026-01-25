package com.regexjunit.junit.bankingtransaction;

import com.exception.banktransactionsystem.InsufficientBalanceException;

public class BankAccount {
	
	double balance;
	
	public BankAccount(double balance) {
		this.balance=balance;
	}
	
	public void deposit(double amount) {
		if(amount>0)
		 balance+=amount;
	}
	
	public void withdraw(double amount) throws InsufficientBalanceException {
		if(amount>balance) {
			throw new InsufficientBalanceException("Insufficient Balance.");
		}
		    balance-=amount;
	}
	
	public double getBalance() {
		return balance;
	}
}
