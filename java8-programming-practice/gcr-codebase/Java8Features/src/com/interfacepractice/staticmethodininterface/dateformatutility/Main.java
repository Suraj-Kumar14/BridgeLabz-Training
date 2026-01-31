package com.interfacepractice.staticmethodininterface.dateformatutility;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		
		LocalDate today=LocalDate.now();
		
		String format1=InvoiceGenerator.formatDate(today,"dd/MM/yyyy");
		String format2=InvoiceGenerator.formatDate(today,"yyyy-MM-dd");
		String format3=InvoiceGenerator.formatDate(today,"MMM dd yyyy");
		
		System.out.println("Invoice Date: "+format1);
		System.out.println("Invoice Date: "+format2);
		System.out.println("Invoice Date: "+format3);
	}

}
