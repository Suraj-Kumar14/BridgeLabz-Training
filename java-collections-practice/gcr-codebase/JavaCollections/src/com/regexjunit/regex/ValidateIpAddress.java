package com.regexjunit.regex;

public class ValidateIpAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ip="192.168.1.1";
		
		String regex="^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|$)){4}$";
		
		if(ip.matches(regex)) {
			System.out.println("Valid IP Address");
		}else {
			System.out.println("Invalid IP Address");
		}
	}

}
