package com.cinemahouse;

import java.time.LocalTime;

public class Movie {
	private String movieName;
	private LocalTime time;
	private double price;
	
	public Movie(String movieName, LocalTime time, double price) {
		this.movieName = movieName;
		this.time = time;
		this.price = price;
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	public LocalTime getTime() {
		return time;
	}
	
	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", time=" + time + "pm, price=" + price + "]";
	}	
}
