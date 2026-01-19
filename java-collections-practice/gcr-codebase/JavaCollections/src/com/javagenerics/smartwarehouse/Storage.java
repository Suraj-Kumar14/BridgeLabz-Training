package com.javagenerics.smartwarehouse;

import java.util.ArrayList;
import java.util.List;

public class Storage<T extends WarehouseItem> {
	List<T>itemList=new ArrayList<>();
	
	//add item
	public void addItem(T item) {
		itemList.add(item);
		System.out.println("Added item.");
	}
	
	//get item
	public List<T> getItemList(){
		return itemList;
	}
	
	//display the item list
		public static void showItem(List<? extends WarehouseItem> item) {
			for(WarehouseItem items : item) {
				System.out.println("\nItem Name: "+items.getItemName());
				System.out.println("Item Price: "+items.getPrice());
				System.out.println("Item Quantity: "+items.getQuantity());
			}
		}
	}