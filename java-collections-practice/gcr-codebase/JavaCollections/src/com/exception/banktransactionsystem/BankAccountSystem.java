package com.exception.banktransactionsystem;

import java.util.Scanner;

public class BankAccountSystem {
	
		public static double withdraw(double amount) throws InsufficientBalanceException{
			double balance=40000;
			if(amount>balance) {
				throw new InsufficientBalanceException("Insufficient balance!");
			}
			if(amount<0) {
				throw new IllegalArgumentException();
			}
			return balance-amount;
		}
		
		
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Amount: ");
		double amount=sc.nextDouble();
			
		try {
			double balance=withdraw(amount);
			System.out.println("Withdrwal successful, new balance: "+balance);
				
		}catch(InsufficientBalanceException e) {
				System.out.println("Insufficient balance!");
		}catch(IllegalArgumentException e) {
			System.out.println("Invalid amount!");
		}
	}

}


