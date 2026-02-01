package com.streamAPI.insuranceclaimanalysis;

public class Claim {
	private int id;
	private String name;
	private String type;
	private double amount;
	
	public Claim(int id, String name, String type, double amount) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public double getAmount() {
		return amount;
	}
	@Override
	public String toString() {
		return "Claim [id=" + id + ", name=" + name + ", type=" + type + ", amount=" + amount + "]";
	}
	
	
}
