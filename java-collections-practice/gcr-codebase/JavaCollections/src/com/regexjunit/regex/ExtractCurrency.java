package com.regexjunit.regex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCurrency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String text="The price is $45.99, and the discount is 10.50";
		String regex="(\\$)?\\d+\\.\\d{2}";
		
		Pattern pattern =Pattern.compile(regex);
		Matcher matcher=pattern.matcher(text);
		
		ArrayList<String>currency=new ArrayList<>();
		while(matcher.find()) {
			currency.add(matcher.group());
		}
		System.out.println(String.join(", ", currency));
	}

}
