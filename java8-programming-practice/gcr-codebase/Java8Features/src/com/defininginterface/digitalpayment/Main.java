package com.defininginterface.digitalpayment;

public class Main {

	public static void main(String[] args) {
		
		DigitalPayment upi=new UPI();
		DigitalPayment creditCard=new CreditCard();
		DigitalPayment wallet=new Wallet();
		
		upi.pay(10000);
		creditCard.pay(12000);
		wallet.pay(5000);
	}

}
