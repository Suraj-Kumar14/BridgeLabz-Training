package com.smartcheckout;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Supermarket {
	
	static HashMap<Integer,Item>items=new HashMap<>();
	static Queue<Customer>customer=new LinkedList<>();

	//add customer
	public void addCustomer(Customer data) {
		customer.add(data);
		System.out.println("Customer added!");
	}
	
	//remove customer
//	public void removeCustomer(Customer data) {
//		if(customer.isEmpty()) {
//			System.out.println("No customer available!");
//			return;
//		}
//		else if(customer.contains(data)) {
//		customer.remove(data);
//		System.out.println("Customer removed successfully!");
//		}
//		else {
//			System.out.println("Customer of this name is not available!");
//		}
//	}
	
	// show customer method
	public void showCustomer() {
	    if (customer != null && !customer.isEmpty()) {
	        System.out.println("Customer Queue:");
	        int position = 1;
	        for (Customer c : customer) {
	            System.out.println(position++ + ". " + c);
	        }
	    } else {
	        System.out.println("No customer available");
	    }
	}


	
	//get price of item
	public void showPrice(int itemId) {
		if(items.containsKey(itemId)) {
			Item item=items.get(itemId);
			System.out.println("Price: "+item.price);
		
		}else {
		System.out.println("Item not found!");
		}
	}
	
	//add item
	public void addItem(Item item) {
		items.put(item.itemId, item);
	}
	
	public void purchase(int itemId, int quan) {
		if(items.containsKey(itemId)) {
			Item item=items.get(itemId);
			
			if(item.quantity>=quan) {
				double totalCost=item.price*quan;
				item.quantity-=quan;
				customer.poll();
				System.out.println("You purchased "+quan+" "+item.itemName );
				System.out.println("Total cost: Rs"+ totalCost);
				System.out.println("Remaining stock: "+item.quantity);
			}else {
				System.out.println("Not enough stock! Available: "+item.quantity);
			}
		}else {
			System.out.println("Item not found!");
		}
	}
	
	public void show() {
		for(Integer itemId: items.keySet()) {
			Item item=items.get(itemId);
			System.out.println("ID "+item.itemId+
					" --> Name: "+item.itemName);
			
			
		}
		System.out.println();
	}
}
