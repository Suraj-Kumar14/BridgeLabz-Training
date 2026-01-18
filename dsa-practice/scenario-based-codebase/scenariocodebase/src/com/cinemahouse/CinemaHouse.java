package com.cinemahouse;

import java.util.ArrayList;

public class CinemaHouse {
	
	ArrayList<Movie>movies=new ArrayList<>();
	
	public void addMovie(Movie movie) {
		movies.add(movie);
		System.out.println("Movie added..");
	}
	
	public void sortMovie() {
		int n=movies.size();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-1-i;j++) {
				if(movies.get(j).getTime().isAfter(movies.get(j+1).getTime())) {
					Movie temp=movies.get(j);
					movies.set(j,movies.get(j+1));
					movies.set(j+1, temp);
				}				
			}
		}
		System.out.println();
	}
	
	public void showMovie() {
		System.out.println("----------Cinepolis---------");
		if(movies.isEmpty()) {
			System.out.println("No shows available.");
			return;
		}else {
			for(Movie movie:movies) {
				System.out.println(movie);
			}
		}
		System.out.println();
	}
}
