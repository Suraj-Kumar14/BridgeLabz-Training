package com.smartuniversitylibrarysystem;

public class Faculty implements User {
    public void getPrivileges() {
        System.out.println("Faculty: Can borrow books for 30 days");
    }
}