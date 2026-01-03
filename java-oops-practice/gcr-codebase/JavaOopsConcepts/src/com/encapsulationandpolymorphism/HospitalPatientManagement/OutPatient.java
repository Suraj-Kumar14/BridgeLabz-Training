package com.encapsulationandpolymorphism.HospitalPatientManagement;

import java.util.ArrayList;
import java.util.List;

public class OutPatient extends Patient implements medicalRecord {

    private double consultationFee;

    // Encapsulated medical data
    private List<String> medicalHistory = new ArrayList<>();

    public OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records:");
        for (String record : medicalHistory) {
            System.out.println("- " + record);
        }
    }
}
