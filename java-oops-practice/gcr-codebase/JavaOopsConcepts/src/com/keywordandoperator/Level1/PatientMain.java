package com.keywordandoperator.Level1;

public class PatientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Set the hospital name (static variable)
	       Patient.setHospitalName("City Hospital");
	       // Create new patient instances
	       Patient patient1 = new Patient("Lathika", 30, "Flu", "P001");
	       Patient patient2 = new Patient("Lidiya", 45, "Fracture", "P002");
	       // Display total number of patients admitted
	       System.out.println("Total Patients Admitted: " + Patient.getTotalPatients());
	       // Display patient details
	       patient1.displayPatientDetails();
	       System.out.println();
	       patient2.displayPatientDetails();

	}

}
