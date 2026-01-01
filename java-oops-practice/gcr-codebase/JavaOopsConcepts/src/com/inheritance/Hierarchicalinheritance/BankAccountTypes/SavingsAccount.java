package com.inheritance.Hierarchicalinheritance.BankAccountTypes;

public class SavingsAccount extends BankAccount {
	protected double interestRate;
	
	//constructor
	public SavingsAccount(String accountNumber,double balance,double interestRate) {
		super(accountNumber,balance);
		this.interestRate=interestRate;
	}
	
	@Override
	public void displayAccountType() {
		System.out.println("Savings Account");
	}
	
	//Apply interest
	public void applyInterest() {
		double interest=balance*interestRate/100;
		balance+=interest;
		System.out.println("Interest applied: "+interest+", New Balance:"+balance);
	}
}
