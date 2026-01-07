package com.LoanBuddy;

public class AutoLoan extends LoanApplication {
	
	protected Applicant applicant;
	public AutoLoan(double loanAmount,int term) {
		super(loanAmount,term,10.0);
	}
	

	public boolean approveLoan(Applicant applicant) {
		 boolean eligible =
	                applicant.getCreditScore() >= 680 &&
	                applicant.getIncome() >= loanAmount * 0.25;

	        setApproved(eligible);
	        return eligible;
	}
}	
	