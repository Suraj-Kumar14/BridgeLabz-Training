package com.interfacepractice.markerinterface.sensitivedatatagging;

public class EncryptionService {
	
	public static void process(Object obj) {
		
		if(obj instanceof SensitiveData) {
			System.out.println("Sensitive data detected-> Encrypted data");
		}else {
			System.out.println("Normal data-> No encryption required");
		}
	}
}
