package com.medwarehouse;

import java.time.LocalDate;

public class Medicine {
	private String medicineName;
	private LocalDate expiryDate
	;
	public Medicine(String medicineName, LocalDate expiryDate) {
		this.medicineName = medicineName;
		this.expiryDate = expiryDate;
	}
	
	public String getMedicineName() {
		return medicineName;
	}
	
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	
	@Override
	public String toString() {
		return "Medicine [medicineName=" + medicineName + ", expiryDate=" + expiryDate + "]";
	}
	
	
}
