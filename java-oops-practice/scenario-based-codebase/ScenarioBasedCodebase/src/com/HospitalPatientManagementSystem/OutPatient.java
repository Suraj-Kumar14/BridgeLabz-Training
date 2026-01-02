package com.HospitalPatientManagementSystem;

public class OutPatient extends Patient {
	private String appointmentDate;
	
	public OutPatient(String name,int age,String medicalHistory,String appointmentDate) {
		super(name,age,medicalHistory);
		this.appointmentDate=appointmentDate;
	}
	
	@Override
	public void displayInfo() {
		System.out.println(getSummary()+", Appointment Date: "+appointmentDate);
	}
}
