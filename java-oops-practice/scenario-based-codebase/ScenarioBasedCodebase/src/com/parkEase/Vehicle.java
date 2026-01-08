package com.parkEase;

public class Vehicle {
	
		private String vehicleId;
		private String type;
		private double hours;
		
		
		public Vehicle(String vehicleId, String type, double hours) {
			this.vehicleId = vehicleId;
			this.type = type;
			this.hours = hours;
		}


		public String getVehicleId() {
			return vehicleId;
		}


		public String getType() {
			return type;
		}


		public double getHours() {
			return hours;
		}
	}

