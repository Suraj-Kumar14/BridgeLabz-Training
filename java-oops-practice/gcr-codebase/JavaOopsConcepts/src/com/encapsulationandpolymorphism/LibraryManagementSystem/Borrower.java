package com.encapsulationandpolymorphism.LibraryManagementSystem;

public class Borrower {
    private String name;
    private String contactNumber;

    public Borrower(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    // No direct setter for contactNumber → secured
}
