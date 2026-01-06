package com.FitTrack;

public class FitTrackApp {
	
	 public static void main(String[] args) {

	        UserProfile user = new UserProfile("Ayaan", 20, 70, 600);

	        CardioWorkout cardio = new CardioWorkout(30);  // 30 min
	        StrengthWorkout strength = new StrengthWorkout(20); // 20 min

	        cardio.startWorkout();
	        cardio.stopWorkout();
	        user.addWorkout(cardio);

	        strength.startWorkout();
	        strength.stopWorkout();
	        user.addWorkout(strength);

	        user.printDailySummary();
	    }
}
