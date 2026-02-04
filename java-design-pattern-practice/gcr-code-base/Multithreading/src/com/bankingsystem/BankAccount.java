package com.bankingsystem;

public class BankAccount {
	
	private int balance=10000;

	public double getBalance() {
		return balance;
	}

	public synchronized void withdraw(int amount,String customerName) {
		System.out.println("[" + customerName + "] Attempting to withdraw " + amount);
		if(balance>=amount) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			balance=balance-amount;
			
			System.out.println("Transaction successful: "+customerName+", Amount: "+amount+", Balance: "+balance);
		}else {
			System.out.println("Transaction failed: "+customerName+", Insufficient balance");
		}
	}
	
	
}
