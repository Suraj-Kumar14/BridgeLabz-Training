package com.methodreferences;

import java.util.Arrays;
import java.util.List;

public class PatientID {

	public static void main(String[] args) {
		
		List<String>patientsIds=Arrays.asList("PA101","PA102","PA103","PA104","PA105");
		
		patientsIds.forEach(System.out::println);

	}

}
