package com.regexjunit.regex;

public class CensorBadWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text="This is a damn bad example with some stupid words";
		String regex="\\b(damn|stupid)\\b";
		
		String output=text.replaceAll(regex, "****");
		
		System.out.println(output);
	}

}
