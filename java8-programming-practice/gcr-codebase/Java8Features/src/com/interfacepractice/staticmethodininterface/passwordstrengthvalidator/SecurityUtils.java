package com.interfacepractice.staticmethodininterface.passwordstrengthvalidator;

public interface SecurityUtils {
	static boolean checkPassword(String password) {
		
		if(password==null)
			return false;
		
		if(password.length()<8)
			return false;
		
		if(!password.matches(".*[A-Z].*"))
			return false;
		
		if(!password.matches(".*[a-z].*"))
			return false;
		
		if(!password.matches(".*\\d.*"))
			return false;
		
		if(!password.matches(".*[@#$%^&+=!].*"))
			return false;
		
		return true;
	}
}
