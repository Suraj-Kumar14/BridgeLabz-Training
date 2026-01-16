package com.gamebox;

public class Main {

	public static void main(String[] args) {
		Game game1 = new StrategyGame("Dot game","Action",1100,7.5);
		Game game2 = new ArcadeGame("Fight Game","Thrill",1000,9.5);
		Game game3 = new StrategyGame("Animal Game","Comedy",100,4.5);
		game1.download();
		
		User solu = new User();
		solu.addGame(game1);
		solu.addGame(game2);
		solu.addGame(game1);

		solu.viewGame();
	}

}
