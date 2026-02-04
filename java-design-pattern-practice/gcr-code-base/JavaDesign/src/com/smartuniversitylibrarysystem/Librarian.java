package com.smartuniversitylibrarysystem;

public class Librarian implements User {
    public void getPrivileges() {
        System.out.println("Librarian: Can manage inventory");
    }
}