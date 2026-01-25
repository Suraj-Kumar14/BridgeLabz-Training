package com.regexjunit.regex;

public class ValidateCreditCardNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String card="2343 1234 2342 5423";
		String regex="^[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}$";
		
		if(card.matches(regex)) {
			System.out.println("Valid card format");
		}else {
			System.out.println("Invalid card format");
		}
	}

}
