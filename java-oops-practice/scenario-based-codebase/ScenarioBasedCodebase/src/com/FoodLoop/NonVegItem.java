package com.FoodLoop;

public class NonVegItem extends FoodItem{

	public NonVegItem(int foodId,String name, String category, double price, boolean availability, int stock) {
		super(foodId,name, "NonVeg", price, availability, stock);

	}
	
}
