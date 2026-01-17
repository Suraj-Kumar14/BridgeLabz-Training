package com.javagenerics.smartwarehouse;

public abstract class WarehouseItem {
	private String itemName;
	private double price;
	private int quantity;
	
	public WarehouseItem(String itemName, double price, int quantity) {
	
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
	
	@Override
	public String toString() {
		return itemName+": Rs"+price;
	}
}
