package com.defininginterface.implementinginterface;

public class Main {

	public static void main(String[] args) {
		
		SmartDevice light=new Lights();
		SmartDevice ac=new AC();
		SmartDevice tv=new TV();
		
		light.turnOn();
		ac.turnOn();
		tv.turnOn();
		System.out.println();
		light.turnOff();
		ac.turnOff();
		tv.turnOff();
		
	}

}
