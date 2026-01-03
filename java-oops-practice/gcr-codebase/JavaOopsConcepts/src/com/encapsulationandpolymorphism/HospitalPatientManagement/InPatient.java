package com.encapsulationandpolymorphism.HospitalPatientManagement;
import java.util.ArrayList;
import java.util.List;

public class InPatient extends Patient implements medicalRecord {

    private double roomChargePerDay;
    private int numberOfDays;

    // Encapsulated medical data
    private List<String> medicalHistory = new ArrayList<>();

    public InPatient(int patientId, String name, int age,double roomChargePerDay, int numberOfDays) {
        super(patientId, name, age);
        this.roomChargePerDay = roomChargePerDay;
        this.numberOfDays = numberOfDays;
    }

    @Override
    public double calculateBill() {
        return roomChargePerDay * numberOfDays;
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
