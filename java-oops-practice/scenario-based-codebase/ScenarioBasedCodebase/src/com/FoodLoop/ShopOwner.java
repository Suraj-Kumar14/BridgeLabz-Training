package com.FoodLoop;

import java.util.ArrayList;
import java.util.List;

public class ShopOwner {
	static List<FoodItem>foodItem=new ArrayList<>();
	
	//shop owner can add food
	protected void addFoodItem(FoodItem newFood) {
		foodItem.add(newFood);
		System.out.println("Food Item added!");
	}
	
	//shop owner can remove food
	protected void removeFoodItem(FoodItem food) {
		if(foodItem.contains(food)) {
		foodItem.remove(food);
		System.out.println("Food Item removed!");
		return;
	   }
		System.out.println("Food not found");
	}
	
	protected void viewFoods() {
		int i=1;
		System.out.println("--------------Foods List----------");
		for(FoodItem items: foodItem) {
			System.out.println("---------------------------");
			System.out.println("Food item:"+i);
			System.out.println("Food Id: "+items.getFoodId());
			System.out.println("Food name: "+items.getName());
			System.out.println("Food price: "+items.getPrice());
			System.out.println("-----------------------------");
			i++;
		}
		System.out.println();
	}
}
