package com.budgetwise;

import java.util.Map;

public class MonthlyBudget extends Budget{
	
	public MonthlyBudget(double income, double limit, Map<String, Double> categoryLimits) {
		super(income, limit, categoryLimits);
	}
}
