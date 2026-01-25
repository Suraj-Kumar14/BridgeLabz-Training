package com.regexjunit.regex;

public class LicensePlateNumberValidator {

	public static boolean isValidLicenseNumber(String numberPlate) {
		String regex="^[A-Z]{2}[0-9]{4}$";
		return numberPlate.matches(regex);
	}
	public static void main(String[] args) {
		
		System.out.println(isValidLicenseNumber("AB1234"));
		System.out.println(isValidLicenseNumber("A12345"));

	}

}
