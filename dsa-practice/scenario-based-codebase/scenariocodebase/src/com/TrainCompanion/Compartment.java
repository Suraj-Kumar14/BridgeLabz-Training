package com.TrainCompanion;

public class Compartment {
	String compartmentName;
	Compartment next;
	Compartment prev;
	Compartment tail;
	
	public Compartment(String compartmentName) {
		this.compartmentName=compartmentName;
		this.prev=null;
		this.next=null;
	}
}
