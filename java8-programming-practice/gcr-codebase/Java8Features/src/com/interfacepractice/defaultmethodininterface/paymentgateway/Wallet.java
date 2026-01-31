package com.interfacepractice.defaultmethodininterface.paymentgateway;

public class Wallet implements PaymentProcessor{

	@Override
	public void pay(double amount) {
		System.out.println("\nPaid Rs"+amount+" using Wallet");		
	}
	
	@Override
	public void refund(double amount) {
		System.out.println("Refund of Rs"+amount+" processed to Wallet instantly.");
	}

}
