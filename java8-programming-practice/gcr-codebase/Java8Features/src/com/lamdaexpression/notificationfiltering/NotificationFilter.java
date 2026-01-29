package com.lamdaexpression.notificationfiltering;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class NotificationFilter {

	public static void main(String[] args) {
		
		List<Alert>alerts=Arrays.asList(new Alert("Emergency","Patient critical"),new Alert("Appointment","Doctor visit at 10 AM"),new Alert("Billing","Payment pending"));

		//predicate using lamda
		
		Predicate<Alert>emergency=alert->alert.getType().equals("Emergency");
		
		// Filtering
        alerts.stream().filter(emergency).forEach(System.out::println);
    
	}

}
