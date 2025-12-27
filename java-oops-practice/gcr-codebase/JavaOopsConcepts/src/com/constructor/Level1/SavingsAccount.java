package com.constructor.Level1;

public class SavingsAccount extends BankAccount {
	//constructor to initialize BankAccount constructor
	public SavingsAccount(int accountNumber,String accountHolder,double balance) {
		super(accountNumber,accountHolder,balance);
	}
	
	//Display account details
	public void displayAccountDetails() {
		System.out.println("Account number: "+accountNumber);
		System.out.println("Account Holder: "+accountHolder);
		System.out.println("Balance: "+getBalance());
	}
	
}
