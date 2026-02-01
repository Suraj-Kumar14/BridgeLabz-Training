package com.streamAPI.trendingmovies;

import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Movie>movies=new ArrayList<>();
		
		movies.add(new Movie("RRR", 8.9, Year.parse("2022")));
		movies.add(new Movie("Bahubali: The Beginning", 8.0, Year.parse("2015")));
		movies.add(new Movie("Bahubali: The Conclusion", 8.2, Year.parse("2017")));
		movies.add(new Movie("KGF Chapter 1", 8.2, Year.parse("2018")));
		movies.add(new Movie("KGF Chapter 2", 8.4, Year.parse("2022")));
		movies.add(new Movie("Pushpa: The Rise", 7.6, Year.parse("2021")));
		movies.add(new Movie("Vikram", 8.4, Year.parse("2022")));
		movies.add(new Movie("Jawan", 7.1, Year.parse("2023")));
		movies.add(new Movie("Pathaan", 5.9, Year.parse("2023")));
		movies.add(new Movie("3 Idiots", 8.4, Year.parse("2009")));
		
		movies.stream()
				.filter(movie->movie.getReleaseYear().isAfter(Year.parse("2020")))
				.sorted(Comparator.comparing(Movie::getRating).reversed().thenComparing(Movie::getReleaseYear,Comparator.reverseOrder()))
				.limit(3)
				.forEach(System.out::println);
				
				
				
						
	}

}
