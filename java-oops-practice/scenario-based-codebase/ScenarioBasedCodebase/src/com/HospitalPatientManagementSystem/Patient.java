package com.HospitalPatientManagementSystem;

public class Patient {
	private String name;
	private int age;
	private String medicalHistory;
	
	//constructor for emergency admission
	public Patient(String name,int age) {
		this.name=name;
		this.age=age;
		this.medicalHistory="Emergency Admission";
	}
	
	//constructor for normal admission
	public Patient(String name,int age,String medicalHistory) {
		this.name=name;
		this.age=age;
		this.medicalHistory="Normal Admission";
	}
	public String getSummary() {
		return "Patient: "+name+ ", Age: "+age;
	}

	public void displayInfo() {
		System.out.println("Patient Info: "+getSummary());
	}
	
}
