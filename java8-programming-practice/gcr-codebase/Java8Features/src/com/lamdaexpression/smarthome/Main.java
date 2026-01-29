package com.lamdaexpression.smarthome;

public class Main {

	public static void main(String[] args) {
		
		SmartLight light=new SmartLight();
		
		LightAction motion=()-> System.out.println("Motion detected!");
		
		LightAction day=()-> System.out.println("Night time");
		
		LightAction voice=()-> System.out.println("Voice command");
		
		light.execute(motion);
		light.execute(day);
		light.execute(voice);

	}

}
