package com.regexjunit.regex;



public class ReplaceMultipleSpaceIntoSingle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String text="This  is an  example      with multiple spaces.";
		String output=text.replaceAll("\\s+"," ");
		
		System.out.println(output);
	}

}
