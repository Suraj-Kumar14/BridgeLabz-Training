package com.LoanBuddy;

public class LoanBuddyMain {
	public static void main(String[] args) {
		Applicant applicant=new Applicant("Suraj Kumar",720,60000.0,150000.0);
		
		LoanApplication loan=new HomeLoan(applicant.getLoanAmount(),240);
		
		if (loan.approveLoan(applicant)) {
            System.out.println("Loan Approved!");
            System.out.println("Monthly EMI: " + loan.calculateEMI());
        } else {
            System.out.println("Loan Rejected.");
        }
   }
}
