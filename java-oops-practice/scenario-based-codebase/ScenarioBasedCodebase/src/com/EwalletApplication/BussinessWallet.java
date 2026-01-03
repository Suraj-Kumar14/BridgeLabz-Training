package com.EwalletApplication;

class BusinessWallet extends Wallet {
    private static final double LIMIT = 200000;

    public BusinessWallet(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void transferTo(User receiver, double amount) {
        double tax = amount * 0.02; // 2% tax
        if(amount + tax <= getBalance() && amount <= LIMIT) {
            withdraw(amount + tax);
            receiver.getWallet().deposit(amount);
            System.out.println("Transferred " + amount + " with tax " + tax + " to " + receiver.getName());
        } else {
            System.out.println("Transfer failed due to limit or insufficient funds!");
        }
    }


}
