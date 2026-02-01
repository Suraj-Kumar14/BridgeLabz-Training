package com.streamAPI.trendingmovies;

import java.time.Year;

public class Movie {
	private String movieName;
	private double rating;
	private Year releaseYear;
	
	public Movie(String movieName, double rating, Year releaseYear) {
		super();
		this.movieName = movieName;
		this.rating = rating;
		this.releaseYear = releaseYear;
	}

	public String getMovieName() {
		return movieName;
	}

	public double getRating() {
		return rating;
	}

	public Year getReleaseYear() {
		return releaseYear;
	}

	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", rating=" + rating + ", releaseYear=" + releaseYear + "]";
	}
	
	
	
}
