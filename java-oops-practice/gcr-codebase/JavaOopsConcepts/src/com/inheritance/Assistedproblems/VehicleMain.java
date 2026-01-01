package com.inheritance.Assistedproblems;

public class VehicleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vehicle car=new Car(140,"Diesel",5);
		Vehicle truck=new Truck(120,"Diesel",3);
		Vehicle motorCycle=new MotorCycle(130,"Petrol",2);
		
		//call display information method
		car.displayInfo();
		truck.displayInfo();
		motorCycle.displayInfo();
	}

}
