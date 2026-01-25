package com.regexjunit.junit.passwordvalidator;

public class PasswordValidator {
	
	public boolean checkPassword(String pass) {
		String regex="^(?=.*[A-Z])(?=.*\\d).{8,}$";
		return pass.matches(regex);
				
	}
}
