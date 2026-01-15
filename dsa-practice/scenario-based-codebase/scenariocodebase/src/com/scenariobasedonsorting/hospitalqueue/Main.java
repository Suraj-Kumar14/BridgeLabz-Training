package com.scenariobasedonsorting.hospitalqueue;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Patient>patients=new ArrayList<>();
		
		HospitalQueue hospital=new HospitalQueue();
		patients.add(new Patient("Allu",7));
		patients.add(new Patient("Ramu",9));
		patients.add(new Patient("Kali",5));
		patients.add(new Patient("Sobha",8));
		
		hospital.patientBeforeSorting(patients);
		
		hospital.sortPatient(patients);
		
		hospital.patientAfterSorting(patients);

	}

}
