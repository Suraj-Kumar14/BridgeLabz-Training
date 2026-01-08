package com.TourMate;

public class Transport implements IBookable{
	private double cost;
	
	public Transport(double cost) {
		this.cost=cost;
	}
	
	public double getCost() {
		return cost;
	}
	
	@Override
	public void book() {
		System.out.println("Transport booked!");
	}
	
	@Override
	public void cancel() {
		System.out.println("Transport cancelled!");
	}
}
