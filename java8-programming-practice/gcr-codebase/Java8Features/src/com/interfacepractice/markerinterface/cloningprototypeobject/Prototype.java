package com.interfacepractice.markerinterface.cloningprototypeobject;

public class Prototype {

	public static void main(String[] args) throws CloneNotSupportedException {

		Employee original=new Employee(101,"Suraj","IT");
		Employee cloned=(Employee)original.clone();

		System.out.println("Original Object:");
		original.display();
		
		System.out.println("Cloned Object:");
		cloned.display();
	}

}
