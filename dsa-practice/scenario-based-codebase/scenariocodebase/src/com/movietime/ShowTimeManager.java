package com.movietime;

import java.util.ArrayList;
import java.util.List;

public class ShowTimeManager {
	
	List<Movie>movies=new ArrayList<>();
	
	//add movies
	public void addMovies(Movie movie) {
		movies.add(movie);
		System.out.println("Movie added.");
	}
	
	//sort movies by insertion sort
	public void sortMovies() {
		int i=0, n=movies.size()-1;
		for(i=1;i<n;i++) {
			Movie top=movies.get(i);
			int j=i-1;
			while(j>=0 && movies.get(j).getShowTime().isAfter(top.getShowTime())) {
				movies.set(j+1,movies.get(j));
				j--;
			}
			j++;
			movies.set(j, top);
		}
	}
	
	
	//show list of movies
	public void showTime() {
		System.out.println("---------Theater show time---------");
		if(!movies.isEmpty()) {
			for(Movie movie:movies) {
				System.out.println(movie);
			}
		}else {
			System.out.println("No show available.");
		}
		System.out.println();
	}
}
