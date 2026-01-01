package com.inheritance.Hierarchicalinheritance.BankAccountTypes;

public class CheckingAccount extends BankAccount {
	protected double withdrawalLimit ;
	
	//constructor
	public CheckingAccount(String accountNumber,double balance,double withdrawalLimit) {
		super(accountNumber,balance);
		this.withdrawalLimit=withdrawalLimit;
	}
	
	@Override
	public void displayAccountType() {
		System.out.println("Checking Account");
	}
	
	@Override
	public void withdraw(double amount) {
		if(amount>withdrawalLimit) {
			System.out.println("Withdrawal denied! Limit is "+withdrawalLimit);			
		}
		else if(amount<=balance) {
			balance-=amount;
			System.out.println("Withdraw amount: "+amount+", Remaining Balance: "+balance);
		}else {
			System.out.println("Insufficient Balance!");
		}
	}
}
