package com.birdsanctuary;

public abstract class Bird {
	private static int counter = 100;
	private String birdName;
	private String species;
	private int birdId;
	
	public Bird(String birdName, String species) {
		this.birdName = birdName;
		this.species = species;
		this.birdId = counter++;
	}

	public String getBirdName() {
		return birdName;
	}

	public String getSpecies() {
		return species;
	}

	public int getBirdId() {
		return birdId;
	}
	
	public void eat() {
		System.out.println(birdName+" is eating.");
	}
	
	public abstract void birdInfo();
}