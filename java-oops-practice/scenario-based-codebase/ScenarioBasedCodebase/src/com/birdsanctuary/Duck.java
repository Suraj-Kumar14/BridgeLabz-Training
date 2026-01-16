package com.birdsanctuary;

public class Duck extends Bird implements ISwimmable, IFlyable{

	public Duck(String birdName) {
		super(birdName,"Anas platyrhynchos");
	}

	@Override
	public void swim() {
		System.out.println(getBirdName()+" is swimming.");
	}

	@Override
	public void birdInfo() {
		System.out.println("Bird Id: "+getBirdId()+"\n"+"Bird Name: "+getBirdName()+"\n"+"Species: "+getSpecies());
	}

	@Override
	public void fly() {
		System.out.println(getBirdName()+" is flying.");
	}
}