package com.PetPal;

import java.util.Random;

public abstract class Pet implements IInteractable {

    protected String name;
    protected String type;
    protected int age;

    private int hunger;
    private int energy;
    private String mood;

    // Constructor with random defaults
    public Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;

        Random rand = new Random();
        this.hunger = rand.nextInt(50) + 50;   
        this.energy = rand.nextInt(50) + 50;
        updateMood();
    }

   
    @Override
    public void feed() {
        hunger -= 20;
        if (hunger < 0) hunger = 0;
        updateMood();
    }

    @Override
    public void play() {
        energy -= 20;
        hunger += 10;
        updateMood();
    }

    @Override
    public void sleep() {
        energy += 30;
        if (energy > 100) energy = 100;
        updateMood();
    }

    
    private void updateMood() {
        if (energy > 60 && hunger < 40)
            mood = "Happy";
        else if (hunger > 70)
            mood = "Hungry";
        else
            mood = "Normal";
    }

    public void showStatus() {
        System.out.println(name + " (" + type + ")");
        System.out.println("Age: " + age);
        System.out.println("Energy: " + energy);
        System.out.println("Hunger: " + hunger);
        System.out.println("Mood: " + mood);
    }

   
    public abstract void makeSound();
}
