package com.gamebox;

public class ArcadeGame extends Game{

	public ArcadeGame(String title, String genre, double price, double rating) {
		super(title, genre, price, rating);
	}
	
	@Override
	public void download() {
		System.out.println("Game started download..");
	}
	
	@Override
	public void playDemo() {
		System.out.println("Game is now started to play..");
	}
}
