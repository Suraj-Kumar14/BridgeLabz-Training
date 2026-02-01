package com.streamAPI.transformingnamesfordisplay;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Customer>customers=new ArrayList<>();
		
		customers.add(new Customer("Kali"));
		customers.add(new Customer("Suraj"));
		customers.add(new Customer("Arvind"));
		customers.add(new Customer("Sujal"));
		customers.add(new Customer("Mohit"));
		customers.add(new Customer("Sonu"));
		customers.add(new Customer("Sohal"));
		customers.add(new Customer("Raju"));
		customers.add(new Customer("Monu"));
		customers.add(new Customer("Vikash"));
		customers.add(new Customer("Arjun"));
		customers.add(new Customer("Ankur"));
		customers.add(new Customer("Titu"));
		
		customers.stream().map(c->c.getName().toUpperCase()).sorted().forEach(System.out::println);
	}

}
