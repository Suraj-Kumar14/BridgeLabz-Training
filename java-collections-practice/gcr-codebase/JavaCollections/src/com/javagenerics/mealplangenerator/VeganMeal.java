package com.javagenerics.mealplangenerator;

public class VeganMeal implements MealPlan{
	private String mealName;
	
	public VeganMeal(String mealName) {
		this.mealName = mealName;
	}

	@Override
	public String getMealName() {
		return mealName;
	}

	@Override
	public String getCategory() {
		return "Vegan Meal";
	}

	@Override
	public void displayMeal() {
		System.out.println(mealName+" | "+"vegan meal.");
	}

}
