package com.budgetwise;

import java.util.Map;

public class AnnualBudget extends Budget{

	public AnnualBudget(double income, double limit, Map<String, Double> categoryLimits) {
		super(income, limit, categoryLimits);
	}

}