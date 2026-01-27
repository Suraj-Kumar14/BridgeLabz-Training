package com.csvfile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SortCSV {
	 public static void main(String[] args) {

	        List<String[]> records = new ArrayList<>();

	        try (BufferedReader br = new BufferedReader(new FileReader("DataFiles/employees.csv"))) {

	            String line;
	            br.readLine(); // skip header

	            while ((line = br.readLine()) != null) {
	                String[] data = line.split(",");
	                records.add(data);
	            }

	        } catch (IOException e) {
	            System.out.println("Error reading file");
	            return;
	        }

	        // Sort by Salary (index 3) in descending order
	        records.sort((a, b) -> 
	            Integer.parseInt(b[3].trim()) - Integer.parseInt(a[3].trim())
	        );

	        System.out.println("Top 5 Highest Paid Employees");
	        System.out.println("--------------------------------");

	        for (int i = 0; i < Math.min(5, records.size()); i++) {
	            String[] emp = records.get(i);

	            System.out.println(
	                "Name: " + emp[1].trim() +
	                ", Department: " + emp[2].trim() +
	                ", Salary: " + emp[3].trim()
	            );
	        }
	    }
}
