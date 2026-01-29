package com.methodreferences.Invoiceobjectcreation;

public class Invoice {
	
	private String transactionId;
	
	public Invoice(String transactionId) {
		this.transactionId=transactionId;
	}
	
	public String getTransactionId() {
		return transactionId;
	}
}
