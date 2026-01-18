package com.cinemahouse;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
	
	public static void main(String[] args) {
		CinemaHouse cinema=new CinemaHouse();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");

		
		cinema.addMovie(new Movie("Houseful",LocalTime.parse("10:00",formatter),220));
		cinema.addMovie(new Movie("Dhurandhar",LocalTime.parse("7:00",formatter),270));
		cinema.addMovie(new Movie("War",LocalTime.parse("11:00",formatter),180));
		cinema.addMovie(new Movie("javaan",LocalTime.parse("8:00",formatter),250));
		cinema.addMovie(new Movie("Border",LocalTime.parse("9:00",formatter),270));
		cinema.addMovie(new Movie("120 Bahadur",LocalTime.parse("5:00",formatter),240));
		System.out.println();
		System.out.println("Movie time before sorting..");
		cinema.showMovie();
		cinema.sortMovie();
		System.out.println("Movie time after sorting..");
		cinema.showMovie();
	
	}
}
