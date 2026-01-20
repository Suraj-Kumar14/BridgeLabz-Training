package com.javagenerics.mealplangenerator;

public class Main {
	
	public static void main(String[] args) {
		Meal<MealPlan> vegan = new Meal<>();
		vegan.addMeal(new VeganMeal("Chicken"));
		vegan.addMeal(new VeganMeal("mutton"));
		vegan.addMeal(new VeganMeal("eggs"));
		
		Meal<MealPlan> veg = new Meal<>();
		veg.addMeal(new VegetarianMeal("Daal Rice"));
		veg.addMeal(new VegetarianMeal("Puri Sabji"));
		
		
		Meal<MealPlan> keto = new Meal<>();
		keto.addMeal(new KetoMeal("Abocardo"));
		keto.addMeal(new KetoMeal("Butter"));
		
		
		vegan.viewMeal();
		System.out.println();
		veg.viewMeal();
		System.out.println();
		keto.viewMeal();
	}
}
