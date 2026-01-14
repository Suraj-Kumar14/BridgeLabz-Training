package com.smartcheckout;

public class Item {
	String itemName;
	int itemId;
	double price;
	int quantity;
	
	
	public Item(String itemName, int itemId, double price, int quantity) {
		super();
		this.itemName = itemName;
		this.itemId = itemId;
		this.price = price;
		this.quantity = quantity;
	}

}
