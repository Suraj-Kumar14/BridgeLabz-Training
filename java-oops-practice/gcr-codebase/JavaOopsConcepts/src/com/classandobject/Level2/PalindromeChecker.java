package com.classandobject.Level2;

public class PalindromeChecker {
	String text;
	
	//Constructor
	PalindromeChecker(String text){
		this.text=text;
	}
	
	//Creating the method to check its palindrome or not
	public boolean isPalindrome() {
		//To remove the space and return consistent text
		String cleantext=text.replaceAll("\\s","").toLowerCase();
		
		//To reverse the String
		String reverseText=new StringBuilder(cleantext).reverse().toString();
		
		return cleantext.equals(reverseText);
	}
	
	//method to display the result
	public void displayResult() {
		if(isPalindrome()) {
			System.out.println(text+" is palindrome");
		}
		else {
			System.out.println(text+" is not plaindrome");
		}
	}
	
	public static void main(String[] args) {
		PalindromeChecker checker1=new PalindromeChecker("A man a plan a canal panama");
		checker1.displayResult();
		
		PalindromeChecker checker2=new PalindromeChecker("Hello");
		checker2.displayResult();
		
		
	}
}
