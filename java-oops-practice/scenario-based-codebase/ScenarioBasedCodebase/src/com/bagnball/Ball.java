package com.bagnball;

public class Ball {
	private int uniqueId;
	private String color;
	private String size;
	
	public Ball(int uniqueId, String color, String size) {
		this.uniqueId = uniqueId;
		this.color = color;
		this.size = size;
	}
	
	public int getUniqueId() {
		return uniqueId;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Ball [uniqueId=" + uniqueId + ", color=" + color + ", size=" + size + "]";
	}
	
}
