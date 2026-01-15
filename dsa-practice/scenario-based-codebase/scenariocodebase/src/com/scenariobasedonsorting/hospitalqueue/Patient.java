package com.scenariobasedonsorting.hospitalqueue;

public class Patient {
	private String name;
	private int criticalLevel;
	
	public Patient(String name, int criticalLevel) {
		this.name=name;
		this.criticalLevel=criticalLevel;
	}

	public String getName() {
		return name;
	}

	public int getCriticalLevel() {
		return criticalLevel;
	}
	
	@Override
	public String toString() {
		return "Patient Name: "+name+", Crictical level: "+criticalLevel;
	}
}
