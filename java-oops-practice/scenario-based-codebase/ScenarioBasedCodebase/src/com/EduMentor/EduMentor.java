package com.EduMentor;

import java.util.Arrays;

public class EduMentor {

    public static void main(String[] args) {

        Learner learner1 = new Learner(
                "suraj",
                "suraj@gmail.com",
                101,
                true);

        learner1.showRole();

        Quiz quiz = new Quiz(
                Arrays.asList("Java is OOP?", "Java supports inheritance?"),
                Arrays.asList("Yes", "Yes"),
                "Easy");

        quiz.evaluate(Arrays.asList("Yes", "Yes"));

        System.out.println("Score: " + quiz.getScore());
        System.out.println("Percentage: " + quiz.calculatePercentage());

        learner1.generateCertificate(); 
    }
}
