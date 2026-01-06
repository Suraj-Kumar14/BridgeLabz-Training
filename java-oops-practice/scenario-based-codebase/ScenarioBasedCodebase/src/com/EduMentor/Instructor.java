package com.EduMentor;

public class Instructor extends User {

    public Instructor(String name, String email, int userId) {
        super(name, email, userId);
    }

    @Override
    public void showRole() {
        System.out.println("Role: Instructor");
    }
}