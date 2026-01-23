package com.avltree.gamingapp;

public class Main {

	public static void main(String[] args) {
		
		GamingLeaderboard lb=new GamingLeaderboard();
		
		lb.addPlayer("Suraj",1200);
		lb.addPlayer("Amit",1500);
		lb.addPlayer("Arvind",1100);
		lb.addPlayer("Sonu",1400);
		
		lb.showLeaderboard();
		
		System.out.println("Removing Suraj...");
		lb.removePlayer(1200);
		
		lb.showLeaderboard();
	}
}
