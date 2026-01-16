package com.birdsanctuary;

public class Eagle extends Bird implements IFlyable{

	public Eagle(String birdName) {
		super(birdName, "Aquila chrysaetos");
	}

	@Override
	public void fly() {
		System.out.println(getBirdName()+" is flying.");
	}
	
	@Override
	public void birdInfo() {
		System.out.println("Bird Id: "+getBirdId()+"\n"+"Bird Name: "+getBirdName()+"\n"+"Species: "+getSpecies());
	}
}