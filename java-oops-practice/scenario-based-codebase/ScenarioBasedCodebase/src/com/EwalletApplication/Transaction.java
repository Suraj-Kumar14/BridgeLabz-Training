package com.EwalletApplication;

public class Transaction {
	 private String type;
	 private double amount;
	 private String details;

	 public Transaction(String type, double amount, String details) {
	    this.type = type;
	    this.amount = amount;
        this.details = details;
    }

    public void printTransaction() {
        System.out.println(type + ": " + amount + " | " + details);
    }

}
