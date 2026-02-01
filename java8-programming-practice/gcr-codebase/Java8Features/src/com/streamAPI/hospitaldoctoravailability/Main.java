package com.streamAPI.hospitaldoctoravailability;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Doctor> doctors = new ArrayList<>();

		doctors.add(new Doctor("Dr. Sharma", "Cardiology", true));
		doctors.add(new Doctor("Dr. Mehta", "Neurology", false));
		doctors.add(new Doctor("Dr. Khan", "Orthopedics", true));
		doctors.add(new Doctor("Dr. Rao", "Dermatology", true));
		doctors.add(new Doctor("Dr. Verma", "Cardiology", false));
		doctors.add(new Doctor("Dr. Iyer", "Neurology", true));
		
		doctors.stream()
				.filter(movie->movie.isAvailableOnWeekend())
				.sorted(Comparator.comparing(Doctor::getSpeciality)).forEach(System.out::println);

	}

}
