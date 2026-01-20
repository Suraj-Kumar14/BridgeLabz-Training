package com.javagenerics.mealplangenerator;

import java.util.ArrayList;
import java.util.List;

public class Meal<T extends MealPlan> {
	private List<T>mealList=new ArrayList<>();
	
	//add meal
	public void addMeal(T meal) {
		mealList.add(meal);
	}
	
	//view meal
	public void viewMeal() {
		for(T meal: mealList) {
			meal.displayMeal();
		}
	}
	
	//get meal
	public List<T>getMeal(){
		return mealList;
	}
}
