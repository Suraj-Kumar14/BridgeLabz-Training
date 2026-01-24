package com.avltree.hospitalqueuemanagement;

import java.time.LocalTime;

public class Patient {
	private String name;
	private LocalTime time;
	private int height;
	Patient left,right;
	
	public Patient(String name, LocalTime time) {
		super();
		this.name = name;
		this.time = time;
		height=1;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Patient [name=" + name + ", time=" + time + "]";
	}
	
	
}
