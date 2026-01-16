package com.budgetwise;

public class BudgetManagement {
	MonthlyBudget monthly;
	AnnualBudget annual;
	Transaction transaction;
	
	//monthly
	public BudgetManagement(MonthlyBudget month, Transaction transaction) {
		this.monthly = month;
		this.transaction = transaction;
	}
	
	//annual
	public BudgetManagement(AnnualBudget annual, Transaction transaction) {
		this.annual = annual;
		this.transaction = transaction;
	}
	
	
	//method to purchase monthly
	public void monthlyTransaction() {
		System.out.println("------------------------------------Monthly-------------------------------------");
		for(var c: monthly.categoryLimits.entrySet()) {
			if(c.getKey().equalsIgnoreCase(transaction.getCategory())) {
				double limitAmount = monthly.categoryLimits.get(c.getKey());
				double buyAmount = transaction.getAmount();
				if(buyAmount<=limitAmount) {
					double remainAmount = limitAmount-buyAmount;
					monthly.categoryLimits.put(transaction.getCategory(), remainAmount);
					System.out.println(transaction.getCategory() + " DONE");
					return;
				}else {
					System.out.println("Sorry! Your Monthly budget limit of "+transaction.getCategory() +" is "+limitAmount);
					return;
				}
			}
		}
		System.out.println("Sorry! Category not found.");
		System.out.println("-------------------------------------------------------------------------------");
	}
	
	//method to purchase annual
	public void annulaTransaction() {
		System.out.println("------------------------------------Annual-------------------------------------");
		for(var c: annual.categoryLimits.entrySet()) {
			if(c.getKey().equalsIgnoreCase(transaction.getCategory())) {
				double limitAmount = annual.categoryLimits.get(c.getKey());
				double buyAmount = transaction.getAmount();
				if(buyAmount<=limitAmount) {
					double remainAmount = limitAmount-buyAmount;
					annual.categoryLimits.put(transaction.getCategory(), remainAmount);
					System.out.println(transaction.getCategory() + " DONE");
					return;
				}else {
					System.out.println("Sorry! Your Annual budget limit of "+transaction.getCategory() +" is "+limitAmount);
					return;
				}
			}
		}
		System.out.println("Sorry! Category not found.");
		System.out.println("-------------------------------------------------------------------------------");
	}
}