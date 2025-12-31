package com.objectmodeling.AssistedProblems;
import java.util.ArrayList;
public class Company {
	 private String companyName;
	    private ArrayList<Department> departments = new ArrayList<>();

	    public Company(String companyName) {
	        this.companyName = companyName;
	    }

	    public void addDepartment(String deptName) {
	        departments.add(new Department(deptName));
	    }

	    public void showCompany() {
	        System.out.println("Company: " + companyName);
	        for (Department d : departments) {
	            d.showDepartment();
	        }
	    }
}
