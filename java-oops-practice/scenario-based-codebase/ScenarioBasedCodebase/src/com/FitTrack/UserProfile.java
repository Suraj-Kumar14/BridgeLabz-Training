package com.FitTrack;
import java.util.*;

public class UserProfile {

    private String name;
    private int age;
    private double weight;  
    private double dailyGoal; 

    private List<Workout> workoutLog; 

    public UserProfile(String name, int age, double weight) {
        this(name, age, weight, 500); 
    }

    public UserProfile(String name, int age, double weight, double dailyGoal) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.dailyGoal = dailyGoal;
        workoutLog = new ArrayList<>();
    }

    public void addWorkout(Workout workout) {
        workoutLog.add(workout);
    }

    public double getTotalCaloriesBurned() {
        double total = 0;
        for (Workout w : workoutLog) {
            total += w.getCaloriesBurned();
        }
        return total;
    }

    public double getRemainingCalories() {
        
        return dailyGoal - getTotalCaloriesBurned();
    }

    public void printDailySummary() {
        System.out.println("User: " + name);
        System.out.println("Daily Goal: " + dailyGoal + " cal");
        System.out.println("Calories Burned: " + getTotalCaloriesBurned() + " cal");
        System.out.println("Remaining: " + getRemainingCalories() + " cal");
    }
}
