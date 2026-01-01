package com.inheritance.Hierarchicalinheritance.BankAccountTypes;

public class BankAccountMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SavingsAccount savingsAccount=new SavingsAccount("38684573674",20000.0,2.5);
		CheckingAccount checkingAccount=new CheckingAccount("38684546474",20000.0,10000.0);
		FixedDepositAccount fixedDepositAccount=new FixedDepositAccount("38684546474",5000,24);
		
		//Display account types
		savingsAccount.displayAccountType();
		checkingAccount.displayAccountType();
		fixedDepositAccount.displayAccountType();
		
		//performing operations
		savingsAccount.applyInterest();
		checkingAccount.withdraw(1000);
	}

}
