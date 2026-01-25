package com.regexjunit.regex;

public class HexColorValidator {

	public static boolean isValidHexColor(String hexcolor) {
		String regex="^#[a-zA-Z0-9]{6}$";
		return hexcolor.matches(regex);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isValidHexColor("#FFA500"));
		System.out.println(isValidHexColor("#ff4500"));
		System.out.println(isValidHexColor("#123"));

	}

}
