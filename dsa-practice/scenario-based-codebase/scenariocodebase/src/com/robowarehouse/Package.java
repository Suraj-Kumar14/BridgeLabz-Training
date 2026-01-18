package com.robowarehouse;

public class Package {
	private String packageId;
	private double weight;
	private double balance;
	
	public Package(String packageId, double weight, double balance) {
		this.packageId = packageId;
		this.weight = weight;
		this.balance = balance;
	}
	
	public String getPackageId() {
		return packageId;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double getBalance() {
		return balance;
	}
	
	@Override
	public String toString() {
		return "Package [packageId=" + packageId + ", weight=" + weight + "kg, balance=" + balance + "]";
	}
	
	
	
}
