package com.foodfest;

public class FoodFest {

	public static void main(String[] args) {
		
		SortingStall stall=new SortingStall();
		stall.addStall(new Stall("Pizza",100));
		stall.addStall(new Stall("Burger",90));
		stall.addStall(new Stall("Sandwitch",150));
		stall.addStall(new Stall("HotDog",130));
		System.out.println();
		
		stall.showStall();
		stall.sortStall();
	
		stall.showStall();
	}

}
