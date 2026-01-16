package com.budgetwise;

import java.util.*;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		//monthly budget
		Map<String, Double> monthlyLimits = new HashMap<>();
		monthlyLimits.put("FOOD", 4000.0);
		monthlyLimits.put("RENT", 8000.0);
		monthlyLimits.put("TRANSPORT", 2000.0);
		monthlyLimits.put("SHOPPING", 3000.0);
		
		MonthlyBudget monthly = new MonthlyBudget(20000,10000,monthlyLimits);
		
		//category item
		Transaction FOOD = new Transaction(1200,"Georocy",LocalDate.now(),"FOOD");
		Transaction RENT = new Transaction(8000,"Georocy",LocalDate.now(),"RENT");
		Transaction SHOPPING = new Transaction(1000,"Georocy",LocalDate.now(),"SHOPPING");
		
		BudgetManagement management1 = new BudgetManagement(monthly,FOOD);
		management1.monthlyTransaction();
		
		BudgetManagement management2 = new BudgetManagement(monthly,RENT);
		management2.monthlyTransaction();
		
		BudgetManagement management3 = new BudgetManagement(monthly,SHOPPING);
		management3.monthlyTransaction();
		
		
		//annual budget
		Map<String, Double> annualLimits = new HashMap<>();
		monthlyLimits.put("FOOD", 40000.0);
		monthlyLimits.put("RENT", 80000.0);
		monthlyLimits.put("TRANSPORT", 20000.0);
		monthlyLimits.put("SHOPPING", 30000.0);
		
		AnnualBudget annual = new AnnualBudget(500000,120000,annualLimits);
		
		//category item
		Transaction FOOD1 = new Transaction(1200,"Georocy",LocalDate.now(),"FOOD");
		Transaction RENT2 = new Transaction(8000,"Georocy",LocalDate.now(),"RENT");
		Transaction SHOPPING3 = new Transaction(1000,"Georocy",LocalDate.now(),"SHOPPING");
		
		BudgetManagement management4 = new BudgetManagement(annual,FOOD1);
		management4.annulaTransaction();
		
		BudgetManagement management5 = new BudgetManagement(annual,RENT2);
		management5.annulaTransaction();
		
		BudgetManagement management6 = new BudgetManagement(annual,SHOPPING3);
		management6.annulaTransaction();
	}
}