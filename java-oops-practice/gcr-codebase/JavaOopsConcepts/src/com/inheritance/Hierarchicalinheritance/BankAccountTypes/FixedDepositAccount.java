package com.inheritance.Hierarchicalinheritance.BankAccountTypes;

public class FixedDepositAccount extends BankAccount{
	private int maturityPeriod;
	
	//constructor
	public FixedDepositAccount(String accountNumber,double balance,int maturityPeriod) {
		super(accountNumber,balance);
		this.maturityPeriod=maturityPeriod;
	}
	
	@Override
	public void displayAccountType() {
		System.out.println("Fixed Deposit Account");
	}
	
}
