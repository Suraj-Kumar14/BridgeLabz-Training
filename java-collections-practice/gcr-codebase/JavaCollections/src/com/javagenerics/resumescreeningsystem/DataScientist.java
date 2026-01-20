package com.javagenerics.resumescreeningsystem;

public class DataScientist extends JobRole {
	private int score;
	public DataScientist(String name,int score) {
		super(name);
		this.score=score;
	}

	@Override
	public String getRole() {
		return "Data Scientist";
	}

	@Override
	boolean screenResume() {
		return score>=70;
	}

}
