package com.interfacepractice.staticmethodininterface.dateformatutility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface InvoiceGenerator {
	
	public static String formatDate(LocalDate date,String pattern) {
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern(pattern);
		return date.format(formatter);
	}
}
