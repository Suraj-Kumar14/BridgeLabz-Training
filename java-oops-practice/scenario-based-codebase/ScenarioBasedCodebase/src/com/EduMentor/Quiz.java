package com.EduMentor;
import java.util.*;

public class Quiz {

	   
    private List<String> questions;

   
    private final List<String> correctAnswers;

    private int score;
    private String difficulty;

  
    public Quiz(List<String> questions, List<String> correctAnswers) {
        this(questions, correctAnswers, "Medium");
    }

    public Quiz(List<String> questions, List<String> correctAnswers, String difficulty) {
        this.questions = questions;
        this.correctAnswers = correctAnswers;
        this.difficulty = difficulty;
        this.score = 0;
    }

  
    public List<String> getQuestions() {
        return questions;
    }

    public int getScore() {
        return score;
    }

  
    public void evaluate(List<String> userAnswers) {
        for (int i = 0; i < correctAnswers.size(); i++) {
            if (userAnswers.get(i).equals(correctAnswers.get(i))) {
                score++; 
            }
        }
    }

   
    public double calculatePercentage() {
        return (score * 100.0) / correctAnswers.size();
    }
}

