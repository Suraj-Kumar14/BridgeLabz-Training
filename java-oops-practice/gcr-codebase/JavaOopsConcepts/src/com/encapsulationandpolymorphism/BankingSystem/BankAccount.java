package com.encapsulationandpolymorphism.BankingSystem;

public abstract class BankAccount {

    // Encapsulated fields
    private String accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }


	// Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    // Getters (controlled access)
    public String getAccountNumber() {
        return "XXXXXX" + accountNumber.substring(accountNumber.length() - 4);
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Abstract method
    public abstract double calculateInterest();
}
