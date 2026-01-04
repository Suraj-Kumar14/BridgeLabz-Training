package com.mybank;

public class CurrentAccount extends Account{
	private double intrestRate;
	
	public CurrentAccount(String accountNumber, double balance, double intrestRate) {
		super(accountNumber, balance, "Current Account");
		this.intrestRate = intrestRate;
		
	}
	
	public void calculateInterest() {
		System.out.println("Intrest: "+(getBalance()*intrestRate/100));
	}
}