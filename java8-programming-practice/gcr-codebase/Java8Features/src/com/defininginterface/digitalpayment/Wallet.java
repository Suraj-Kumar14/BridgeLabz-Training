package com.defininginterface.digitalpayment;

public class Wallet implements DigitalPayment{

	@Override
	public void pay(double amount) {
		System.out.println("Paid Rs " + amount + " using Wallet");
		
	}

}
