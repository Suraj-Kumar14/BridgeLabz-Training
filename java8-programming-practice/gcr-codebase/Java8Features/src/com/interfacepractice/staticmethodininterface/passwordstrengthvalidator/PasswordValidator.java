package com.interfacepractice.staticmethodininterface.passwordstrengthvalidator;

import java.util.Scanner;

public class PasswordValidator {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter password: ");
		String password=sc.nextLine();
		
		if(SecurityUtils.checkPassword(password)==true) {
			System.out.println("Strength password!");
		}else {
			System.out.println("Not strength password");
		}
	}

}
