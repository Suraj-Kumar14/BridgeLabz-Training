package com.interfacepractice.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TemperatureAlertSystem {

	public static void main(String[] args) {
		
		double threshold=35.0;
		Predicate<Double>isThreshold=temp->temp>threshold;
		
		List<Double>temperatures=Arrays.asList(35.0,30.5,32.4,35.2,40.0);
		
		temperatures.stream().filter(isThreshold).forEach(System.out::println);
		
	}

}
