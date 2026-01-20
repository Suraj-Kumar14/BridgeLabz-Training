package com.movietime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MovieTime {

	public static void main(String[] args) {
		
		ShowTimeManager time=new ShowTimeManager();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("H:m");;
		
		time.addMovies(new Movie("Dhurandhar",LocalTime.parse("12:00",formatter)));
		time.addMovies(new Movie("Dhurandhar",LocalTime.parse("10:00",formatter)));
		time.addMovies(new Movie("Dhurandhar",LocalTime.parse("17:00",formatter)));
		time.addMovies(new Movie("Dhurandhar",LocalTime.parse("14:30",formatter)));
		time.addMovies(new Movie("Dhurandhar",LocalTime.parse("21:00",formatter)));
		System.out.println();
		time.showTime();
		time.sortMovies();
		System.out.println();
		time.showTime();
		
	}

}
