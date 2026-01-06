package com.EventEase;
import java.util.*;
public class EventEasePlatform {
	    public static void main(String[] args) {

	        User organizer = new User("Ayaan", "ayaan@mail.com", "9876543210");

	        List<String> attendees = Arrays.asList("Alice", "Bob", "Charlie");

	        BirthdayEvent birthday = new BirthdayEvent("Ayaan's Birthday", "Garden Hall", "2026-01-15",
	                attendees, 10000, true, true);
	        birthday.setDiscount(1000); 
	        birthday.schedule();
	        System.out.println("Total Cost: " + birthday.getTotalCost());

	        ConferenceEvent conference = new ConferenceEvent("Tech Conference", "Convention Center", "2026-03-10", attendees, 20000, true, false);
	               
	        conference.schedule();
	        System.out.println("Total Cost: " + conference.getTotalCost());

	        // Reschedule and cancel
	        birthday.reschedule("2026-01-20");
	        conference.cancel();
	    }
}

