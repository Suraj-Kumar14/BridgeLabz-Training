package com.bagnball;

public class Bag {
	private int uniqueId;
	private String color;
	private int capacity;
	
	public Bag(int uniqueId, String color, int capacity) {
		this.uniqueId = uniqueId;
		this.color = color;
		this.capacity = capacity;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getUniqueId() {
		return uniqueId;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	@Override
	public String toString() {
		return "Bag [uniqueId=" + uniqueId + ", color=" + color + ", capacity=" + capacity + "]";
	}
	
	
}
