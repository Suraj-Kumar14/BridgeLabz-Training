package com.javagenerics.smartwarehouse;

import java.util.List;

public class Display {
	public void showItem(List<? extends WarehouseItem> item) {
		for(WarehouseItem items: item) {
			System.out.println("\nItem Name: "+items.getItemName());
			System.out.println("Item Price: "+items.getPrice());
			System.out.println("Item Quantity: "+items.getQuantity());
		}
	}
}
