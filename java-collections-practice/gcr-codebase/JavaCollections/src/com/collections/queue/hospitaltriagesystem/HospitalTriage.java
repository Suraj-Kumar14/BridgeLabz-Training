package com.collections.queue.hospitaltriagesystem;

import java.util.PriorityQueue;

public class HospitalTriage {
	PriorityQueue<Patient>patients=new PriorityQueue<>();
	
	public void addPatient(Patient patient) {
		patients.add(patient);
		System.out.println("Patient added.");
	}
	
	public void showPatient() {
		System.out.println("--------Patients Details-------");
		if(!patients.isEmpty()) {
			for(Patient p: patients) {
				System.out.println(p);
			}
		}else {
			System.out.println("No patient available.");
		}
		System.out.println();
	}
	
}
