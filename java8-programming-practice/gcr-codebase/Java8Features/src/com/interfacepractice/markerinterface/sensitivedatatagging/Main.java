package com.interfacepractice.markerinterface.sensitivedatatagging;

public class Main {

	public static void main(String[] args) {
		
		UserCredentials credentials=new UserCredentials("Suraj123","Hello@123");
		ProductInfo product=new ProductInfo("Laptop",65000);
		
		EncryptionService.process(credentials);
		EncryptionService.process(product);
	}

}
