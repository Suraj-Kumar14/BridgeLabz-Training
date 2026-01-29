package com.methodreferences.Invoiceobjectcreation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceGenerator {

	public static void main(String[] args) {
		
		List<String>transactionIds=Arrays.asList("TXN101","TXN102","TXN103","TXN104");

		List<Invoice>invoices=transactionIds.stream().map(Invoice::new).collect(Collectors.toList());
		
		invoices.forEach(invoice->System.out.println(invoice.getTransactionId()));
	}

}
