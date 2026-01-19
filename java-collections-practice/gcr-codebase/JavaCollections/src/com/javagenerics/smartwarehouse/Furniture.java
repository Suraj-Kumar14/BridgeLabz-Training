package com.javagenerics.smartwarehouse;

public class Furniture extends WarehouseItem{

	public Furniture(String itemName, double price, int quantity) {
		super(itemName, price, quantity);		
	}

	@Override
	public String toString() {
		return getItemName()+": Rs"+getPrice();
	}	
}
