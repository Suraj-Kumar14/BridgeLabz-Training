package com.javagenerics.mealplangenerator;

public class VegetarianMeal implements MealPlan{
	
	private String mealName;
	
	public VegetarianMeal(String mealName) {
		this.mealName = mealName;
	}
	
	@Override
	public String getMealName() {
		
		return mealName;
	}
	

	@Override
	public String getCategory() {
		return "Vegetarian Meal";
	}

	@Override
	public void displayMeal() {
		System.out.println(mealName+" | "+" Vegetarian meal.");		
	}

}
