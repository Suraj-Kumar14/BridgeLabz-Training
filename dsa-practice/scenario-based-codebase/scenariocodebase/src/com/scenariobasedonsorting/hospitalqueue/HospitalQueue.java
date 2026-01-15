package com.scenariobasedonsorting.hospitalqueue;

import java.util.ArrayList;
import java.util.List;

public class HospitalQueue {
	
	//sort patient based on critical level
	public void sortPatient(ArrayList<Patient>patients) {
		int n=patients.size();
		
	for(int i=0;i<n-1;i++) {
		for(int j=0;j<n-1-i;j++) {
			if(patients.get(j).getCriticalLevel()<patients.get(j+1).getCriticalLevel()) {
				Patient temp=patients.get(j);
				patients.set(j,patients.get(j+1));
				patients.set(j+1,temp);				
			}
		}
   	}
	
	}	
	
	public void patientBeforeSorting(ArrayList<Patient>patients) {
		System.out.println("Before sorting!");
		for(Patient p: patients) {
			System.out.println(p);
		}
		System.out.println();
	}
	
	public void patientAfterSorting(ArrayList<Patient>patients) {
		System.out.println("After sorting!");
		for(Patient p: patients) {
			System.out.println(p);
		}
	}
}
