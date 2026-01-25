package com.regexjunit.junit.registrationtesting;

public class UserRegistration {
	
	public boolean registerUser(String username,String email,String password) {
		if(username==null || username.length()<5) {
			throw new IllegalArgumentException("Invalid username");
		}
		
	    if (email == null || !email.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email");	  
         }

        if (password == null || !password.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$")) {
           throw new IllegalArgumentException("Invalid password");
	     }
        
		return true;
	}
}
