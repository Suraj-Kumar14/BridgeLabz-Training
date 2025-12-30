package com.objectmodeling.AssistedProblems;

public class Account {
	private static int nextId=1;
	private int accountId;
	private double balance;
	private Bank bank;
	
	//constructor
	public Account(Bank bank) {
		this.accountId=nextId++;
		this.balance=0.0;
		this.bank=bank;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
	public void deposit(double amount) {
		balance+=amount;
	}
}
