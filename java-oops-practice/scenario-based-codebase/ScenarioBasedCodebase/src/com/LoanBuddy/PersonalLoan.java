package com.LoanBuddy;

public class PersonalLoan extends LoanApplication{

		public PersonalLoan(double loanAmount,int term) {
			super(loanAmount, term,14.5);
		}
		
		@Override
		public boolean approveLoan(Applicant applicant) {
			boolean eligible=applicant.getCreditScore()>=650 && applicant.getIncome()>=loanAmount*0.3;
			
			setApproved(eligible);
			return eligible;
		}
}
