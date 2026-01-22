package com.bagnball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToyStorage {
	
	Map<Integer,List<Ball>>bagball=new HashMap<>();
	List<Bag>bags=new ArrayList<>();
	
	//add bags
	public void addBag(Bag bag) {
		bags.add(bag);
		System.out.println("Bag added.");
	}
	
	public void addBall(Ball newBall,int bagId) {
		for(Bag b:bags) {
			if(b.getUniqueId()==bagId) {
				if(!bagball.containsKey(bagId)) {
					List<Ball>newBall1=new ArrayList<>();
					newBall1.add(newBall);
					bagball.put(bagId, newBall1);
					System.out.println("Ball added to bag with id: "+bagId);
					return;
				}
				List<Ball>list=bagball.get(bagId);
				list.add(newBall);
				bagball.put(bagId, list);
				System.out.println("Ball added to bag with id: "+bagId);
				return;
			}
		}
		System.out.println("\nBag is not found!");
	}

	//remove balls
	public void removeBalls(int bagId) {
		if(!bagball.containsKey(bagId)) {
			System.out.println("\nBag id not found.");
			return;
		}
		List<Ball> list = bagball.get(bagId);
		list.clear();
		bagball.put(bagId, list);
		System.out.println("\nBall removed sucess.");
	}
		
	//display all balls
	public void displayAllBalls() {
		System.out.println("-----------------All Balls---------------");			
		if(bagball.isEmpty()) {
		System.out.println("Bag is empty. there is not balls");
				return;
		}
		for(var b : bagball.entrySet()) {
			List<Ball> balls = bagball.get(b.getKey());
			if(balls.isEmpty()) {
				System.out.println("For bag with id: "+b.getKey()+" ball list empty!");
			}else {
				System.out.println("\nBag id "+b.getKey()+" ball list-");
				ballDetails(balls);
			}
		}
		System.out.println();
	}
	
	//bag details
		public void bagDetails(int bagId) {
			for(Bag b : bags) {
				System.out.println("Bag Id: "+b.getUniqueId());
				System.out.println("Bag Color: "+b.getColor());
				System.out.println("Bag Capacity: "+b.getCapacity());
			}
		}
		
		//display balls
		public void ballDetails(List<Ball> ballsList) {
			for(Ball b : ballsList) {
				System.out.println("\nBall Id: "+b.getUniqueId());
				System.out.println("Ball Color: "+b.getColor());
				System.out.println("Ball Size: "+b.getSize());
			}
		}
}
