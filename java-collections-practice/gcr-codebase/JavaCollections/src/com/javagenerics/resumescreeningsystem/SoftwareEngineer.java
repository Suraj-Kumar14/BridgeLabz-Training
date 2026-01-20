package com.javagenerics.resumescreeningsystem;

public class SoftwareEngineer extends JobRole{
	private int score;
	public SoftwareEngineer(String name,int score) {
		super(name);
		this.score=score;
	}

	@Override
	public String getRole() {
		return "Software Engineer";
	}

	@Override
	boolean screenResume() {
		return score>=80;
	}

}
