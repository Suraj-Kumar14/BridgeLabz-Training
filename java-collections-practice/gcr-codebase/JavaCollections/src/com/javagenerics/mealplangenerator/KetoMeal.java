package com.javagenerics.mealplangenerator;

public class KetoMeal implements MealPlan{
	private String mealName;
		
	public KetoMeal(String mealName) {
		this.mealName = mealName;
	}

	@Override
	public String getMealName() {
		return mealName;
	}

	@Override
	public String getCategory() {
		return "Keto Meal";
	}

	@Override
	public void displayMeal() {
		System.out.println(mealName+" | "+"Keto meal.");	
	}

}
