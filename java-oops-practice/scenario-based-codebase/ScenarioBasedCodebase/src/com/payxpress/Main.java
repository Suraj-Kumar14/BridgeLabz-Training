package com.payxpress;

public class Main {

	public static void main(String[] args) {
		ElectricityBill electricBills = new ElectricityBill();
		electricBills.pay(1000);
		electricBills.showBill();
		

		InternetBill internetBills = new InternetBill();
		internetBills.pay(800);
		internetBills.showBill();
		
		
		WaterBill waterBills = new WaterBill();
		waterBills.pay(100);
		waterBills.showBill();
	}
}
