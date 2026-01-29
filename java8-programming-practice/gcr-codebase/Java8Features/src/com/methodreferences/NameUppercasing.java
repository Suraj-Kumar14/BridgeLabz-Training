package com.methodreferences;

import java.util.Arrays;
import java.util.List;

public class NameUppercasing {

	public static void main(String[] args) {
		
		List<String>employeeNames=Arrays.asList("Mohit","Sohan","Arvind","Kali","Sonu");
		
		employeeNames.stream().map(String::toUpperCase).forEach(System.out::println);
	}

}
