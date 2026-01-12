package com.TrainCompanion;

public class Main {
	
	public static void main(String[] args) {
		
		TrainManagement train=new TrainManagement();
		
		train.insertCompartment("s1");
		train.insertCompartment("s2");
		train.insertCompartment("s3");
		train.insertCompartment("pantry");
		train.displayCompartment();
		System.out.println();
		train.forward("pantry");
		train.backward("pantry");
		train.insertCompartment("s4");
		System.out.println();
		train.displayCompartment();
		System.out.println();
		train.forward("pantry");
		train.backward("pantry");
		train.removeCompartment("s3");
		train.displayCompartment();
		train.removeCompartment("pantry");
	}
}
