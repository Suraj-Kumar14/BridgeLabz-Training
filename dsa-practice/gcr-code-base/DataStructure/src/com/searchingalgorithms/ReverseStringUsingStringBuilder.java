package com.searchingalgorithms;

public class ReverseStringUsingStringBuilder {
	 public static void main(String[] args) {
	        String input = "hello";

	        String reversed = reverseString(input);

	        System.out.println("Reversed string: " + reversed);
	    }

	    public static String reverseString(String str) {
	        // Step 1: Create StringBuilder object
	        StringBuilder sb = new StringBuilder();

	        // Step 2: Append the string
	        sb.append(str);

	        // Step 3: Reverse using StringBuilder's reverse method
	        sb.reverse();

	        // Step 4: Convert back to String and return
	        return sb.toString();
	    }
}