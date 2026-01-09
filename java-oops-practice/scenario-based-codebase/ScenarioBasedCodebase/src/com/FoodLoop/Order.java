package com.FoodLoop;

import java.util.ArrayList;
import java.util.List;

public class Order implements IOrderable{
	
	 protected List<FoodItem>orderList=new ArrayList<>();      
	private double total;
	User users;
	
	public Order(User users) {
		this.users=users;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public void placeOrder(int foodId) {
		for(FoodItem items: ShopOwner.foodItem) {
			if(items.getFoodId()==foodId) {	
				orderList.add(items);
				total+=items.getPrice();
				System.out.println("Order placed!");
				return;
			}
		}
		System.out.println("Unavailable food item");
	}
	
	@Override
	public void cancelOrder(int foodId) {
		for (FoodItem items:ShopOwner.foodItem) {
			if(items.getFoodId()==foodId) {
				orderList.remove(items);
				total-=items.getPrice();
				System.out.println("\nOrder cancel succesfully");
				System.out.println("-------New Bill------");
				return;
			}
		}
		System.out.println("You not yet purchased this food!");
	}
	
	public void viewBill() {
		int j=1;
		System.out.println("\n----------Food Bill Amount------------");
		double totalBill = 0.0;
		for(FoodItem item:orderList) {
			System.out.println("Food item "+j+"------");
			System.out.println("Food name:"+item.getName());
			System.out.println("Food Price: "+item.getPrice());
			System.out.println("-----------------");
			j+=1;
		}
		System.out.println("Total Price----> : "+total);
		return;
	}
}
