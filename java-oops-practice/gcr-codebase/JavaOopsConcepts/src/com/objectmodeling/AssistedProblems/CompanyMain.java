package com.objectmodeling.AssistedProblems;

public class CompanyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Company company = new Company("Tech Corp");

        company.addDepartment("IT");
        company.addDepartment("HR");

        company.showCompany();

       //company deleted
        company = null;
	}

}
