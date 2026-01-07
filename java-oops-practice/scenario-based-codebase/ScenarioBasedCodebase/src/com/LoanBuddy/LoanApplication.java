package com.LoanBuddy;

public abstract class LoanApplication implements IApprovable {
	
	protected double loanAmount;
	protected int term;
	protected double interestRate;
	
	protected boolean approved;
	
	public LoanApplication(double loanAmount,int term,double interest) {
		this.loanAmount=loanAmount;
		this.term=term;
		this.interestRate=interestRate;
	}

	protected void setApproved(boolean approved) {
		this.approved=approved;
	}
	
	public boolean isApproved() {
		return approved;
	}
	
	@Override
	public double calculateEMI() {
		double monthlyRate=interestRate/12/100;
		int n=term;
		
		return (loanAmount * monthlyRate*Math.pow(1+monthlyRate,n))/(Math.pow(1+monthlyRate, n)-1);
	}
	
}
