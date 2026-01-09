package com.FoodLoop;

public class User {
	
	private String name;
	private double walletBalance;
	
	public User(String name, double walletBalance) {
		
		this.name = name;
		this.walletBalance = walletBalance;
	}

	public double getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}

	public String getName() {
		return name;
	}
	
	//check balance
	public void checkBalance() {
		System.out.println("--------User Balance---------");
		System.out.println("Balance: "+getWalletBalance());
	}
}
