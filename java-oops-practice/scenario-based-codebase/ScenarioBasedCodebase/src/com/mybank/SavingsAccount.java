package com.mybank;

public class SavingsAccount extends Account{
	private double intrestRate;
	
	public SavingsAccount(String accountNumber, double balance, double intrestRate) {
		super(accountNumber, balance,"Saving Account");
		this.intrestRate = intrestRate;
		
	}
	
	public void calculateInterest() {
		System.out.println("Intrest: "+(getBalance()*intrestRate/100));
	}
}