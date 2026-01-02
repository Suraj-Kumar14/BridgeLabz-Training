package com.HospitalPatientManagementSystem;

public class Doctor {
	private String name;
	private String specilization;
	
	public Doctor(String name,String specilization) {
		this.name=name;
		this.specilization=specilization;
	}
	
	public void displayInfo() {
		System.out.println("Doctor name: "+name+"\nSpecilization: "+specilization);
	}
}
