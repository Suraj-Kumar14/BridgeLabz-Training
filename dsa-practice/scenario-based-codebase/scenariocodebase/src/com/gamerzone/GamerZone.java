package com.gamerzone;

public class GamerZone {

	public static void main(String[] args) {
		
		HighScoreRanking score=new HighScoreRanking();
		score.addPlayer(new Player("aalu",123));
		score.addPlayer(new Player("kalu",110));
		score.addPlayer(new Player("bholu",145));
		score.addPlayer(new Player("ali",90));
		score.addPlayer(new Player("dhoni",185));
		score.addPlayer(new Player("rohit",264));
		score.addPlayer(new Player("kohli",183));
		score.addPlayer(new Player("ishan",219));
		
		score.showPlayer();
		score.sortPlayer();
		score.showPlayer();
	}

}
