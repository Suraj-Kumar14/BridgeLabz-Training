package com.gamebox;

import java.util.ArrayList;
import java.util.List;

public class User {
static List<Game> userGameList = new ArrayList<>();
	
	public void addGame(Game game) {
		userGameList.add(game);
		System.out.println("Game added.");
	}
	
	public void removeGame(Game game) {
		if(userGameList.isEmpty()) {
			System.out.println("Game list is empty!");
			return;
		}
		userGameList.remove(game);
		System.out.println("Game removed success.");
	}
	
	public void viewGame() {
		if(userGameList.isEmpty()) {
			System.out.println("List is empty.");
			return;
		}
		
		for(Game games:userGameList) {
			System.out.println("\nGame title: "+games.getTitle());
			System.out.println("Game genra: "+games.getGenre());
			System.out.println("Game price: "+games.getPrice());
			System.out.println("Game Price: "+games.getRating());
		}
	}
}
