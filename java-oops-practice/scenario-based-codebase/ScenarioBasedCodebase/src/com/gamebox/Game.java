package com.gamebox;

public class Game implements IDownloadable{
	
	private String title;
	private String genre;
	private double price;
	private double rating;
	
	public Game(String title, String genre, double price, double rating) {
	
		this.title = title;
		this.genre = genre;
		this.price = price;
		this.rating = rating;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getRating() {
		return rating;
	}

	@Override
	public void download() {
				
	}

	@Override
	public void playDemo() {
			
	}
	
	
}
