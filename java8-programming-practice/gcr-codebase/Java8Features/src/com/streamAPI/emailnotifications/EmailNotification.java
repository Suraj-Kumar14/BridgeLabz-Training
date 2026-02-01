package com.streamAPI.emailnotifications;

import java.util.Arrays;
import java.util.List;

public class EmailNotification {

	public static void main(String[] args) {
		
		List<String>email=Arrays.asList("example@123","suraj@123","bholu@123","monu@123","golu@123");

		email.stream().forEach(e->sendEmailNotification(e));
	}

	private static void sendEmailNotification(String email) {
		System.out.println("Notification send success to "+email);
	}
}
