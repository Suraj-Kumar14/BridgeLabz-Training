package com.csvfile;

import java.io.*;
import java.util.regex.Pattern;

public class ValidateCSV {
	
	private static final String EMAIL_REGEX =
	            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

		private static final String PHONE_REGEX =
	            "^[0-9]{10}$";
	    
	    public static void main(String[] args) {

	        Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
	        Pattern phonePattern = Pattern.compile(PHONE_REGEX);

	        try (BufferedReader br = new BufferedReader(new FileReader("DataFiles/testemail.csv"))) {

	            String line;
	            int rowNumber = 0;

	            //skip header
	            br.readLine(); 

	            while ((line = br.readLine()) != null) {
	                rowNumber++;

	                String[] data = line.split(",");

	                String email = data[2].trim();
	                String phone = data[3].trim();

	                boolean valid = true;
	                StringBuilder errorMsg = new StringBuilder();

	                // Email validation
	                if (!emailPattern.matcher(email).matches()) {
	                    valid = false;
	                    errorMsg.append("Invalid Email ");
	                }

	                // Phone validation
	                if (!phonePattern.matcher(phone).matches()) {
	                    valid = false;
	                    errorMsg.append("Invalid Phone Number ");
	                }

	                // Print invalid rows
	                if (!valid) {
	                    System.out.println("❌ Invalid Row " + rowNumber);
	                    System.out.println("Data: " + line);
	                    System.out.println("Error: " + errorMsg.toString());
	                    System.out.println("--------------------------------");
	                }
	            }

	        } catch (IOException e) {
	            System.out.println("Error reading CSV file");
	        }
	    }   	 
	    
}
