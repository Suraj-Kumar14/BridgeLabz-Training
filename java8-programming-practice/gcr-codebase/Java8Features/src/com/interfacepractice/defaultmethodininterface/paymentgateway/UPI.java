package com.interfacepractice.defaultmethodininterface.paymentgateway;

public class UPI implements PaymentProcessor{

	@Override
	public void pay(double amount) {
		System.out.println("\nPaid of Rs"+amount+" using UPI.");
		
	}

}
