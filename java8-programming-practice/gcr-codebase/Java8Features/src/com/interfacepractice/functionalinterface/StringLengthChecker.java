package com.interfacepractice.functionalinterface;

import java.util.function.Function;

public class StringLengthChecker {

	public static void main(String[] args) {
		
		String message="Welcome to java programming";
		int limit=10;
		
		Function<String,Integer>stringLength=str->str.length();
		
		int length=stringLength.apply(message);
		
		if(length>limit) {
			System.out.println("Message exceed limit");
		}else {
			System.out.println("Message is in limit");
		}
		
		System.out.println(message);
	}

}
