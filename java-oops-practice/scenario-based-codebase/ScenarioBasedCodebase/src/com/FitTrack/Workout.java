package com.FitTrack;

public abstract class Workout implements ITrackable {

    protected String type;
    protected int duration; // in minutes
    protected double caloriesBurned;

    public Workout(String type, int duration) {
        this.type = type;
        this.duration = duration;
        this.caloriesBurned = 0;
    }

    public abstract void calculateCalories(); 

    @Override
    public void startWorkout() {
        System.out.println(type + " workout started.");
    }

    @Override
    public void stopWorkout() {
        calculateCalories();
        System.out.println(type + " workout stopped. Calories burned: " + caloriesBurned);
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
    }
}
