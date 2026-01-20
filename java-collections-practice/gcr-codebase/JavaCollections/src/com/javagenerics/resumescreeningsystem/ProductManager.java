package com.javagenerics.resumescreeningsystem;

public class ProductManager extends JobRole{
	private int communicationScore;
	
	public ProductManager(String name,int score) {
		super(name);
		this.communicationScore=score;
	}

	@Override
	public String getRole() {
		return "Product Manager";
	}

	@Override
	boolean screenResume() {
		return communicationScore>=85;
	}

}
