package com.collections.queue.hospitaltriagesystem;

public class Main {

	public static void main(String[] args) {
		
		HospitalTriage ht=new HospitalTriage();
		ht.addPatient(new Patient("John",3));
		ht.addPatient(new Patient("Alice",5));
		ht.addPatient(new Patient("Bob",2));
		
		ht.showPatient();
	}

}
