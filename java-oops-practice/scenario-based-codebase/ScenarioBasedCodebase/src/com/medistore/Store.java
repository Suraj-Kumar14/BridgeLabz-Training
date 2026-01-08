package com.medistore;

import java.time.LocalDate;
import java.util.ArrayList;

public class Store {
	ArrayList<Medicine>medicine=new ArrayList<>();
	
	public void addMedicine(String type,String name,double price,LocalDate expiryDate,int quantity) {
		if(type.equalsIgnoreCase("Tablet")) {
			medicine.add(new Tablet(name,price,expiryDate,quantity));
			System.out.println("Medicine Succesfully added");
			return;
		}
		if(type.equalsIgnoreCase("Syrup")) {
			medicine.add(new Syrup(name,price,expiryDate,quantity));
			System.out.println("Medicine added successfully");
			return;
		}
		System.out.println("Medicine not Added");
	}
	
	public void removeMedicine(String name) {
		for(Medicine m: medicine) {
			if(m.getName().equalsIgnoreCase(name)) {
				medicine.remove(m);
				System.out.println("Medicine removed successfully");
				return;
			}
		}
		System.out.println("Medicine not found!");
	}
	
	public void view() {
		for(Medicine m:medicine) {
			m.details();
		}
	}
	
	public void sell(String name,int quantity) {
		for(Medicine m: medicine) {
			if(m.getName().equalsIgnoreCase(name)) {
				m.sell(quantity);
				return;
			}
		}
		System.out.println("Medicine not Found");
	}
}
