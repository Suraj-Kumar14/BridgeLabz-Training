package com.defininginterface.digitalpayment;

public class UPI implements DigitalPayment{

	@Override
	public void pay(double amount) {
		System.out.println("Paid Rs " + amount + " using UPI");
		
	}

}
