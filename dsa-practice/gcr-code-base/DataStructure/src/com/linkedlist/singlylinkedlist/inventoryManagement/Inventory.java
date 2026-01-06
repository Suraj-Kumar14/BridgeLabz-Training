package com.linkedlist.singlylinkedlist.inventoryManagement;

public class Inventory {
	public String itemName;
	public int itemID;
	public int Quantity;
	public double Price;
	Inventory next;
	
	public Inventory(String n, int d, int q, double p) {
		this.itemName = n;
		this.itemID = d;
		this.Quantity = q;
		this.Price = p;
		this.next = null;
	}
}