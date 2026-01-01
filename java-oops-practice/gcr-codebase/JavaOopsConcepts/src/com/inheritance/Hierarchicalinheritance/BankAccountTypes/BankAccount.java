package com.inheritance.Hierarchicalinheritance.BankAccountTypes;

public class BankAccount {
	protected String accountNumber;
	protected double balance;
	
	//constructor
	public BankAccount(String accountNumber,double balance) {
		this.accountNumber=accountNumber;
		this.balance=balance;
	}
	
	//Deposit method
	public void deposit(double amount) {
		balance+=amount;
		System.out.println("Deposited amount: "+amount+", New Balance: "+balance);
	}
	
	//withdraw method
	public void withdraw(double amount) {
		if(amount<=balance) {
			System.out.println("Withdrawn: "+amount+", Remaining Balance: "+balance);
		}
		else {
			System.out.println("Insufficient Ballance!");
		}
	}
	
	//show balance
	public void displayBalance() {
		System.out.println("Account Number: "+accountNumber+", Balance: "+balance);
	}
	public void displayAccountType() {
		System.out.println();
	}
}
