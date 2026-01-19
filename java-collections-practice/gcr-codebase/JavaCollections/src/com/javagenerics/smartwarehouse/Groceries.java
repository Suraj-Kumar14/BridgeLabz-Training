package com.javagenerics.smartwarehouse;

public class Groceries extends WarehouseItem{

	public Groceries(String itemName, double price, int quantity) {
		super(itemName, price, quantity);
	
	}
	
	@Override
	public String toString() {
		return getItemName()+": Rs"+getPrice();
	}	
}
