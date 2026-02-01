package com.streamAPI.eventwelcomemessage;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String>attendee=List.of("Suraj","Golu","Allu","Monu");
		
		attendee.stream().forEach(name->System.out.println("Welcome "+name+" to the event"));

	}

}
