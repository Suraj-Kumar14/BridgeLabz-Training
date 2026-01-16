package com.budgetwise;

import java.util.Map;

public class Budget {
	private double income;
	private double limit;
    Map<String, Double> categoryLimits;
	
	
	public Budget(double income, double limit, Map<String,Double> categoryLimits) {
		
		this.income = income;
		this.limit = limit;
		this.categoryLimits = categoryLimits;
	}


	public double getIncome() {
		return income;
	}


	public double getLimit() {
		return limit;
	}
		
}
