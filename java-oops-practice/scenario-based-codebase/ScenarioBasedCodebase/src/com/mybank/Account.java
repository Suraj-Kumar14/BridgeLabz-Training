package com.mybank;

abstract class Account implements ITransaction{
	private String accountNumber;
	private double balance;
	private String type;
	
	public Account(String accountNumber, double balance, String type) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.type = type;
	}

	@Override
	public void deposit(double amount) {
		if(amount>0) {
			balance+=amount;
			System.out.println("Deposit Success: "+amount);
		}else {
			System.out.println("Invalid amount!"+amount);
		}
		System.out.println("------------------------------------");
	}

	@Override
	public void withdraw(double amount) {
		if(amount>0 && amount<=balance) {
			balance-=amount;
			System.out.println("Withdrawal Success: "+amount);
		}else {
			System.out.println("Invalid amount!"+amount);
		}
		System.out.println("------------------------------------");
	}

	@Override
	public void checkBalance() {
		System.out.println(type);
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Balance: "+balance);
		System.out.println("------------------------------------");
	}
	
	public abstract void calculateInterest();
	
	public double getBalance() {
		return balance;
	}
	
	public void saving() {
		
	}
}