package com.EduMentor;

public class Learner extends User implements ICertifiable {

    private boolean isFullTime;

    public Learner(String name, String email, int userId, boolean isFullTime) {
        super(name, email, userId);
        this.isFullTime = isFullTime;
    }

    @Override
    public void showRole() {
        System.out.println("Role: Learner");
    }

   
    @Override
    public void generateCertificate() {
        if (isFullTime) {
            System.out.println("Generating Full-Time Course Certificate for " + name);
        } else {
            System.out.println("Generating Short Course Certificate for " + name);
        }
    }
}