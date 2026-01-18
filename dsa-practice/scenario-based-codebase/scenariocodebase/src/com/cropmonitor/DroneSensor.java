package com.cropmonitor;

import java.util.ArrayList;
import java.util.List;

public class DroneSensor {
	
	List<Soil>soilTemperature=new ArrayList<>();
	
	public void addSoil(Soil soil) {
		soilTemperature.add(soil);
		System.out.println("Soil temperature added.");
	}
	
	public void sortSoilTemperature() {
		int start=0,end=soilTemperature.size()-1;
		
		quickSort(start,end);
		System.out.println("Soil temperature measured..");
	}
	
	private void quickSort(int start,int end){
		if(start<end) {
			int pi=partition(start,end);
			
			quickSort(start,pi-1);
			quickSort(pi+1,end);
		}
	}
	
	private int partition(int start,int end) {
		int i=start-1;
		
		for(int j=start;j<end;j++) {
			if(soilTemperature.get(j).getTime().isBefore(soilTemperature.get(end).getTime())) {
				i++;
				Soil soil=soilTemperature.get(i);
				soilTemperature.set(i,soilTemperature.get(j));
				soilTemperature.set(j, soil);
			}				
		}
		i++;
		Soil soil=soilTemperature.get(i);
		soilTemperature.set(i,soilTemperature.get(end));
		soilTemperature.set(end, soil);
		
		return i;
	}	
	
	public void showSoilTemperature() {
		System.out.println("----------Drone Sensor----------");
		if(soilTemperature.isEmpty()) {
			System.out.println("No soil temperature measured.");
			return;
		}else {
			for(Soil soil:soilTemperature) {
				System.out.println(soil);
			}
		}
		System.out.println();
	}
}
