package com.EwalletApplication;

public class PersonalWallet extends Wallet implements Transferrable{
	
	private static final double LIMIT = 50000;

    public PersonalWallet(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void transferTo(User receiver, double amount) {
        if(amount <= LIMIT && amount <= getBalance()) {
            withdraw(amount);
            receiver.getWallet().deposit(amount);
            System.out.println("Transferred " + amount + " to " + receiver.getName());
        } else {
            System.out.println("Transfer limit exceeded or insufficient funds!");
        }
    }

}
