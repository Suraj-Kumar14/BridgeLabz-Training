package com.HospitalPatientManagementSystem;

public class InPatient extends Patient {
	private int roomNumber;
	
	public InPatient(String name,int age,String medicalHistory,int roomNumber) {
		super(name,age,medicalHistory);
		this.roomNumber=roomNumber;
	}
	
	@Override
	public void displayInfo() {
		System.out.println(getSummary()+", Room: "+roomNumber);
	}

}
