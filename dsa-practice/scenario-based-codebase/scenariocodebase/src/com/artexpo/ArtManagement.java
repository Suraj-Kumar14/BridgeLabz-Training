package com.artexpo;

import java.util.ArrayList;
import java.util.List;

public class ArtManagement {
	
	private List<Artist>artist=new ArrayList<>();
	
	public void addArtist(Artist art) {
		artist.add(art);
		System.out.println("Artist added");
		System.out.println();
	}
	
	public void sortArtist() {
		int n=artist.size();
		for(int i=1;i<n;i++) {
			Artist top=artist.get(i);
			int j=i-1;
			while(j>=0 && artist.get(j).getTime().isAfter(top.getTime())) {
				artist.set(j+1,artist.get(j));
				j--;
			}
			j++;
			artist.set(j, top);
		}
		System.out.println("Sorted based on time!");
		System.out.println();
	}
	
	
	public void displayArtist() {
		if(!artist.isEmpty()) {
		for(var art: artist) {
			System.out.println(art);
		}
		}
		else {
			System.out.println("No Artist added yet!");
		}
		System.out.println();
	}
}
