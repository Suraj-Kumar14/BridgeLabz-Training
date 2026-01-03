package com.encapsulationandpolymorphism.HospitalPatientManagement;

public abstract class Patient {
    protected int patientId;
    protected String name;
    protected int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public String getPatientDetails() {
        return "Patient ID: " + patientId +
               ", Name: " + name +
               ", Age: " + age;
    }
}
