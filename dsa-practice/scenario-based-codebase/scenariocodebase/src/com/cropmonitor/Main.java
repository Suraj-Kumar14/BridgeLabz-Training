package com.cropmonitor;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
	public static void main(String[] args) {
		DroneSensor ds=new DroneSensor();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
		
		ds.addSoil(new Soil(34,LocalTime.parse("10:00",formatter)));
		ds.addSoil(new Soil(37,LocalTime.parse("8:00",formatter)));
		ds.addSoil(new Soil(40,LocalTime.parse("11:00",formatter)));
		ds.addSoil(new Soil(45,LocalTime.parse("7:00",formatter)));
		ds.addSoil(new Soil(39,LocalTime.parse("12:00",formatter)));
		ds.showSoilTemperature();
		ds.sortSoilTemperature();
		ds.showSoilTemperature();
	}
}
