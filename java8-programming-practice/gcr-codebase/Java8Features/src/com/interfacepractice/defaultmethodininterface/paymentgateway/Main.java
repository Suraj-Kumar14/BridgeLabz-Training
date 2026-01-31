package com.interfacepractice.defaultmethodininterface.paymentgateway;

public class Main {

	public static void main(String[] args) {
		
		PaymentProcessor upi=new UPI();
		PaymentProcessor creditCard=new CreditCard();
		PaymentProcessor wallet=new Wallet();
		
		upi.pay(300);
		upi.refund(200);
		
		creditCard.pay(400);
		creditCard.refund(200);
		
		wallet.pay(1000);
		wallet.refund(400);	
	}

}
