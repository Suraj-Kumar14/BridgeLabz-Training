package com.UniversityCourseEnrollment;

public class Postgraduate extends Student implements Graded {

    public Postgraduate(int id, String name, double gpa) {
        super(id, name, gpa);
    }

    // Pass / Fail grading
    @Override
    public void assignGrade(double marks) {
        if (marks >= 50)
            setGpa(3.5);
        else
            setGpa(0.0);
    }

    @Override
    public void displayInfo() {
        System.out.println("Postgraduate → " + getTranscript());
    }
}