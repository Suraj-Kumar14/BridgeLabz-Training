package com.birdsanctuary;

import java.util.*;

public class BirdSanctuary {
	static List<Bird> birdList = new ArrayList<>();
	
	//add birds
	public void addBirds(Bird birds) {
		birdList.add(birds);
		System.out.println("Added Bird.");
	}
	
	//search birds by id
	public void searchBirds(int id) {
		for(Bird birds: birdList) {
			if(birds.getBirdId()==id) {
				System.out.println("\n--Bird found--");
				System.out.println("Bird Id: "+birds.getBirdId()+"\n"+"Bird Name: "+birds.getBirdName()+"\n"+"Species: "+birds.getSpecies());
				return;
			}
		}
		System.out.println("--Bird not found--");
	}
	
	//display all birds
	public void displayAllBirds() {
		System.out.println("\n--------------------------------------------Birds List--------------------------------------------");
		for(Bird birds: birdList) {
			System.out.println("\nBird Id: "+birds.getBirdId()+"\n"+"Bird Name: "+birds.getBirdName()+"\n"+"Species: "+birds.getSpecies());
		}
		System.out.println("--------------------------------------------------------------------------------------------------");
	}
	
	//remove birds
	public void removeBirds(int id) {
		for(Bird birds: birdList) {
			if(birds.getBirdId()==id) {
				birdList.remove(birds);
				System.out.println("\n--Bird Removed--");
				System.out.println("Bird Id: "+birds.getBirdId()+"\n"+"Bird Name: "+birds.getBirdName()+"\n"+"Species: "+birds.getSpecies());
				return;
			}
		}
		System.out.println("--Bird not found --");
	}
	
	//view birds report
    public void report() {
        int fly = 0, swim = 0, both = 0, none = 0;

        for (Bird b : birdList) {
            boolean f = b instanceof IFlyable;
            boolean s = b instanceof ISwimmable;

            if (f && s) both++;
            else if (f) fly++;
            else if (s) swim++;
            else none++;
        }

        System.out.println("---- Sanctuary Report ----");
        System.out.println("Flyable: " + fly);
        System.out.println("Swimmable: " + swim);
        System.out.println("Both: " + both);
        System.out.println("Neither: " + none);
    }
}