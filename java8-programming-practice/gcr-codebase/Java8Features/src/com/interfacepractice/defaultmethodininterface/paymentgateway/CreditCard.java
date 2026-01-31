package com.interfacepractice.defaultmethodininterface.paymentgateway;

public class CreditCard implements PaymentProcessor{

	@Override
	public void pay(double amount) {
		System.out.println("\nPaid RS"+amount+" using Credit card");		
	}
	
}
