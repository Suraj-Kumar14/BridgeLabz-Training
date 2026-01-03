package com.EwalletApplication;

public abstract class Wallet implements Transferrable{
	private double balance;
	
	public Wallet(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    protected void deposit(double amount) {
        balance += amount;
    }

    protected void withdraw(double amount) {
        if(amount <= balance) balance -= amount;
        else System.out.println("Insufficient funds!");
    }
	
}
