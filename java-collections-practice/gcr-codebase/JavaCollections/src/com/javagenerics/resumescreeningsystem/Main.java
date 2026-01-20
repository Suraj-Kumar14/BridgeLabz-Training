package com.javagenerics.resumescreeningsystem;

public class Main {
	
	public static void main(String[] args) {
		JobRole data = new DataScientist("sonu",53);
		Resume<JobRole> resume = new Resume<>(data);
		resume.processScreening();
		System.out.println();
		
		JobRole software = new SoftwareEngineer("monu",83);
		Resume<JobRole> resume1 = new Resume<>(software);
		resume1.processScreening();
		System.out.println();
		
		JobRole product = new ProductManager("Ravi",53);
		Resume<JobRole> resume2 = new Resume<>(product);
		resume2.processScreening();
	}
}
