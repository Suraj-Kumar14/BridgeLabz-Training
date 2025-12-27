package com.constructor.Level1;

public class BankAccount {
	//public variable
	public int accountNumber;
	//protected variable
	protected String accountHolder;
	//private variable
	private double balance;
	
	//constructor
	public BankAccount(int accountNumber,String accountHolder,double balance) {
		this.accountNumber=accountNumber;
		this.accountHolder=accountHolder;
		this.balance=balance;
	}
	//Access balance
	public double getBalance() {
		return balance;
	}
	//modify balance
	public void modifyBalance(double balance) {
		this.balance=balance;
	}
}
