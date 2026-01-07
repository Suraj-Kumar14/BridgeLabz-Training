package com.LoanBuddy;

public interface IApprovable {
	boolean approveLoan(Applicant applicant);
	double calculateEMI();
}
