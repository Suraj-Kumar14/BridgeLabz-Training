package com.objectmodeling.AssistedProblems;

public class BankMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank bank=new Bank("City Bank");
		Customer customer=new Customer("Alice");
		
		Account acc1=bank.openAccount(customer);
		acc1.deposit(500);
		
		Account acc2=bank.openAccount(customer);
		acc2.deposit(1000);
		
		customer.viewBalance();
	}

}
