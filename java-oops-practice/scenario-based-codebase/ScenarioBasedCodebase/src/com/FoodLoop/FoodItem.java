package com.FoodLoop;

public class FoodItem {
	private int foodId;
	private String name;
	private String category;
	private double price;
	protected boolean availability;
	private int stock;
	
	 
	public FoodItem(int foodId,String name, String category, double price,boolean availability,int stock) {
		this.foodId=foodId;
		this.name = name;
		this.category = category;
		this.price = price;
		this.availability=availability;
		this.stock=stock;
	}


	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public String getCategory() {
		return category;
	}
	
	boolean isAvailable() {
		return availability &&stock>0;
	}
	
	public int getFoodId() {
		return foodId;
	}
	public void reduceStock() {
		if(stock>0)
			stock--;
	}
}
