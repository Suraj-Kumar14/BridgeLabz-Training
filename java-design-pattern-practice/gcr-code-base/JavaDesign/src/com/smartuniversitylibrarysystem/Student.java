package com.smartuniversitylibrarysystem;

public class Student implements User {
    public void getPrivileges() {
        System.out.println("Student: Can borrow books for 14 days");
    }
}