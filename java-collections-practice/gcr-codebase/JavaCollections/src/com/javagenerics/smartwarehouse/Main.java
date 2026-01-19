package com.javagenerics.smartwarehouse;

public class Main {
	public static void main(String[] args) {
		
		Storage<Electronics>electronics=new Storage<>();
		electronics.addItem(new Electronics("Freeze",14500,5));
		electronics.addItem(new Electronics("Mobile",23500,4));
		
		Storage<Furniture>furniture=new Storage<>();
		furniture.addItem(new Furniture("Godrej",12500,10));
		furniture.addItem(new Furniture("Chair",4500,6));
		
		Storage<Groceries>groceries=new Storage<>();
		groceries.addItem(new Groceries("Rice",500,5));
		groceries.addItem(new Groceries("Milk",64,10));
		System.out.println();
		System.out.print("-------Electronics Item--------");
		Storage.showItem(electronics.getItemList());
		System.out.println();
		System.out.print("-------Furniture Item--------");
		Storage.showItem(furniture.getItemList());
		System.out.println();
		System.out.print("-------Groceries Item--------");
		Storage.showItem(groceries.getItemList());
		
	}
}
