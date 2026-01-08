package com.TourMate;

public class Activity implements IBookable {
	private double cost;
	
	public Activity(double cost) {
		this.cost=cost;
	}
	
	public double getCost() {
		return cost;
	}
	
	@Override
	public void book() {
		System.out.println("Activity booked!");
	}
	
	@Override
	public void cancel() {
		System.out.println("Activity cancelled!");
	}
}
