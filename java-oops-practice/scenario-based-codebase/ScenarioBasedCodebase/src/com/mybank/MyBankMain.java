package com.mybank;

public class MyBankMain {

	public static void main(String[] args) {
		SavingsAccount sa = new SavingsAccount("ASDF1234",1200,5);
		
		ITransaction it = sa;
		Account ac = sa;
		it.checkBalance();
		it.withdraw(800);
		it.deposit(2000);
		it.checkBalance();
		ac.calculateInterest();
		
		
		
		SavingsAccount sa2 = new SavingsAccount("ASDF1234",100,4);
		ITransaction it2 = sa2;
		it2.checkBalance();
		it2.withdraw(8200);
		it2.deposit(100);
		it2.checkBalance();
		
		Account ac2 = sa2;
		ac2.calculateInterest();
	}
}
