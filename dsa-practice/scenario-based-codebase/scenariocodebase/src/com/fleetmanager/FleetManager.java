package com.fleetmanager;

import java.util.ArrayList;
import java.util.List;

public class FleetManager {
	
	List<Vehicle>vehicles=new ArrayList<>();
	
	//Add vehicle
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
		System.out.println("Vehicle added!");
	}
	
	// Sort Vehicles - Merge Sort
	public void sortVehicle() {
		int st = 0, end = vehicles.size()-1;
			
		mergeSort(st, end);
		System.out.println("Vehicles sorted successfully by mileage");
	}
	
	private void mergeSort(int st, int end) {
		if(st < end) {
			int mid = (st + end) / 2;
				
			mergeSort(st, mid);
			mergeSort(mid+1, end);
				
			merge(st, mid, end);
		}
	}
	
	private void merge(int st, int mid, int end) {
		int n1 = mid - st + 1;
		int n2 = end - mid;
		
		List<Vehicle> left = new ArrayList<>(vehicles.subList(st, mid+1));
		List<Vehicle> right = new ArrayList<>(vehicles.subList(mid+1, end+1));
		
		int i = 0, j = 0, k = st;
		
		while(i < n1 && j < n2) {
			if(left.get(i).getMileage() <= right.get(j).getMileage()) {
				vehicles.set(k++, left.get(i++));
			} else {
				vehicles.set(k++, right.get(j++));
			}
		}
		while(i < n1) {
			vehicles.set(k++, left.get(i++));
		}
		while(j < n2) {
			vehicles.set(k++, right.get(j++)); 
		}
	}
	
	// Print Vehicles details
	public void showVehicleDetails() {
		if(vehicles.isEmpty()) {
			System.out.println("No vehicle present");
			System.out.println();
			return; 
		}
			
		System.out.println("Vehicle Details are: ");
		for(Vehicle vehicle : vehicles) {
			System.out.println(vehicle);
		}
		System.out.println();
	}
	
}
