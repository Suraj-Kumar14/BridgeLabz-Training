package com.avltree.gamingapp;

public class Player {
	private String name;
	private int score;
	private int height;
	
	Player left,right;

	
	public Player(String name, int score) {
		this.name = name;
		this.score = score;
		height=1;
		
	}	

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public void setHeight(int height) {
		this.height=height;
	}
	
	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", score=" + score + ", height=" + height + "]";
	}	
	
}
