package com.artexpo;

import java.time.LocalTime;

public class Artist {
	private String name;
	private LocalTime time;
	
	
	public Artist(String name, LocalTime time) {
		this.name = name;
		this.time = time;
	}


	public String getName() {
		return name;
	}


	public void setTime(LocalTime time) {
		this.time = time;
	}


	public LocalTime getTime() {
		return time;
	}
	
	public String toString() {
		return "Name: "+name+" || Time: "+time;
	}
}
