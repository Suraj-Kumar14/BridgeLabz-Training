package com.birdsanctuary;

public class Penguin extends Bird implements ISwimmable{

	public Penguin(String birdName) {
		super(birdName, "Aptenodytes forsteri");
	}
	
	@Override
	public void swim() {
		System.out.println(getBirdName()+ " is Swimming.");
	}
	
	@Override
	public void birdInfo() {
		System.out.println("Bird Id: "+getBirdId()+"\n"+"Bird Name: "+getBirdName()+"\n"+"Species: "+getSpecies());
	}
}