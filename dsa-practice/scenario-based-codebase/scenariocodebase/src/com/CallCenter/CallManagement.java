package com.CallCenter;

import java.util.*;

public class CallManagement {
	Customer customer;
	
	Queue<Customer>incomingCalls=new LinkedList<>();
	LinkedHashMap<String,Integer>customerData=new LinkedHashMap<>();
	
	public void addCustomer(Customer customer) {
		incomingCalls.add(customer);
		String cusId = customer.getPhoneNo();
		customerData.put(cusId,customerData.getOrDefault(cusId, 0)+1);
	}
	
	public void showCustomerData() {
		if(!customerData.isEmpty()) {
    		for(var cus:customerData.entrySet()) {
			   System.out.println("Customer phoneNo: "+cus.getKey()+"\nCustomer Call frequency: "+cus.getValue());
		}
     	}else {
		System.out.println("Empty History!");
		System.out.println();
	   }		
	}
}
