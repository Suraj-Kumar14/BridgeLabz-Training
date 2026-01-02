package com.HospitalPatientManagementSystem;

public class Bill implements Payable{
	private double amount;
	private double discount;
	private double taxRate;
	
	public Bill(double amount,double discount,double taxRate) {
		this.amount=amount;
		this.discount=discount;
		this.taxRate=taxRate;
	}
	@Override
	public double calculatePayment() {
		double total=amount-discount;
		double tax=total*taxRate;
		return total+tax;
	}
	
}
