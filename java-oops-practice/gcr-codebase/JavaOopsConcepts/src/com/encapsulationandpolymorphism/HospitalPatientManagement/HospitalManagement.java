package com.encapsulationandpolymorphism.HospitalPatientManagement;

public class HospitalManagement {
	public static void main(String[] args) {

        Patient patient1 = new InPatient(101, "Rahul", 45, 2000, 5);
        Patient patient2 = new OutPatient(102, "Anita", 30, 500);

        System.out.println(patient1.getPatientDetails());
        System.out.println("Bill Amount: " + patient1.calculateBill());
        System.out.println();

        System.out.println(patient2.getPatientDetails());
        System.out.println("Bill Amount: " + patient2.calculateBill());
    }
}
