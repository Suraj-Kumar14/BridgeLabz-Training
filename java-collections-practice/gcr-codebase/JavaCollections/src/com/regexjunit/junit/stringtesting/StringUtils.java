package com.regexjunit.junit.stringtesting;

public class StringUtils {
	public String reverse(String str) {		
		String rev="";
		for(int i=str.length()-1;i>=0;i--) {
			rev+=str.charAt(i);
		}
		return rev;
	}
	
	public boolean isPalindrome(String str) {
		String palindrome=str;
		String rev="";
		for(int i=str.length()-1;i>=0;i--) {
			rev+=str.charAt(i);
		}
		if(rev.equals(palindrome)) {
			return true;
		}else {
			return false;
		}
	}
	
	public String toUpperCase(String str) {
		return str.toUpperCase();
	}
}
