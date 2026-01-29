package com.defininginterface.digitalpayment;

public class CreditCard implements DigitalPayment{

	@Override
	public void pay(double amount) {
		System.out.println("Paid Rs " + amount + " using CreditCard");
		
	}

}
