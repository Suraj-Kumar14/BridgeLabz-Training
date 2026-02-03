package com.scenarioquestion.banking_finance;

public class Account {
	private long accountNumber;
	private String name;
	private double amount;
	public Account(long accountNumber,String name, double amount) {
		this.accountNumber=accountNumber;
		this.name = name;
		this.amount = amount;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public String getName() {
		return name;
	}
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount=amount;
	}
	@Override
	public String toString() {
		return "Account [name=" + name + ", amount=" + amount + "]";
	}
	
	
}
