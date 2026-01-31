package com.interfacepractice.markerinterface.sensitivedatatagging;

public class UserCredentials implements SensitiveData{
	
	private String username;
	private String password;
	
	public UserCredentials(String username, String password) {
		this.username=username;
		this.password=password;		
	}
	
	public String getPassword() {
		return password;
	}
}
