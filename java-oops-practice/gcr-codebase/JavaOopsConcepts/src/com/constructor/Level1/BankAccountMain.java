package com.constructor.Level1;

public class BankAccountMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SavingsAccount account =new SavingsAccount(1234567891,"Rahul Singh",83000.0);
		account.displayAccountDetails();
		account.modifyBalance(97000.0);
		account.displayAccountDetails();
	}

}
