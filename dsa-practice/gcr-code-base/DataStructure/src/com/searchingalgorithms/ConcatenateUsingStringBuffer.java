package com.searchingalgorithms;

public class ConcatenateUsingStringBuffer {
	public static void main(String[] args) {
		String []str= {"Hello","Hii","Come","Go"};
		
		System.out.print("Before Cocatenate: ");
		for(int i=0;i<str.length;i++) {
			System.out.print(str[i]+" ");
		}
		System.out.println();
		String input=concatenateString(str);
		
		System.out.println("After concatenate: "+input);
	}
	
	public static String concatenateString (String[] str) {
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<str.length;i++) {
			sb.append(str[i]);
		}
		
		return sb.toString();
	}
}
