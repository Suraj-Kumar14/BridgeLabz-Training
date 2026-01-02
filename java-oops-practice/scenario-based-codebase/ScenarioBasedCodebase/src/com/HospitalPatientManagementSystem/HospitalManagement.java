package com.HospitalPatientManagementSystem;

public class HospitalManagement {
	public static void main(String [] args) {
		 Patient p1 = new InPatient("John Doe", 45, "Diabetes", 101);
	        Patient p2 = new OutPatient("Jane Smith", 30, "Flu", "2026-01-05");

	        Doctor d1 = new Doctor("Dr. Sharma", "Cardiology");

	        Bill b1 = new Bill(5000, 500, 0.18);

	        p1.displayInfo();
	        d1.displayInfo();
	        System.out.println("-----------------------");
	        p2.displayInfo();
	        d1.displayInfo();

	        System.out.println("Final Bill: " + b1.calculatePayment());

	}
}
