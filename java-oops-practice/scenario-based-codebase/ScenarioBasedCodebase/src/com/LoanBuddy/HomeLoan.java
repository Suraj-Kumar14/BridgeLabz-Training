package com.LoanBuddy;

public  class HomeLoan extends LoanApplication {
	
	public HomeLoan(double loanAmount,int term) {
		super(loanAmount,term,8.5);
	}
	

	public boolean approveLoan(Applicant applicant) {
		boolean eligible=applicant.getCreditScore()<750 && applicant.getIncome()>=loanAmount*0.2;
		
		setApproved(eligible);
		
		return eligible;
	}

	
	public double calculateEMI() {
		interestRate-=0.5;
		return super.calculateEMI();
	}
	
}