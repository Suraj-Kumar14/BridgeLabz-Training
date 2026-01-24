package com.avltree.hospitalqueuemanagement;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class HospitalManagement {

	public static void main(String[] args) {
      DateTimeFormatter formatter=DateTimeFormatter.ofPattern("H:mm");
		
		HospitalQueueManagement hospital=new HospitalQueueManagement();
		
		hospital.patientRegistration("Allu", LocalTime.parse("10:00",formatter));
		hospital.patientRegistration("monu", LocalTime.parse("09:00",formatter));
		hospital.patientRegistration("sonu", LocalTime.parse("12:00",formatter));
		hospital.patientRegistration("Bholu", LocalTime.parse("11:00",formatter));
		
		hospital.showPatient();
		
		hospital.deleteRecord(LocalTime.parse("9:00",formatter));
		
		hospital.showPatient();
		
		hospital.deleteRecord(LocalTime.parse("11:00",formatter));
		
		hospital.showPatient();
		
	}
}
