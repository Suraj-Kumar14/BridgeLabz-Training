package com.FoodLoop;

public class Main {

	public static void main(String[] args) {
		
		
		FoodItem item1=new VegItem(101,"Shahi Paneer","Veg",219,true,10);
		FoodItem item2=new VegItem(102,"Paalak Paneer","Veg",179,true,10);
		FoodItem item3=new VegItem(103,"Kheer","Veg",79,true,5);
		
		FoodItem item4=new NonVegItem(104,"Biryani","NonVeg",209,true,8);
		FoodItem item5=new NonVegItem(105,"Chicken Tikka","NonVeg",169,true,5);
		FoodItem item6=new NonVegItem(106,"Tandoori Mutton ","NonVeg",349,true,6);
		
		ShopOwner owner=new ShopOwner();
		owner.addFoodItem(item1);
		owner.addFoodItem(item2);
		owner.addFoodItem(item3);
		owner.addFoodItem(item4);
		owner.addFoodItem(item5);
		owner.addFoodItem(item6);
		
		User user=new User("suraj",1000);
		
		owner.viewFoods();
		
		Order order=new Order(user);
		order.placeOrder(102);
		order.placeOrder(103);
		order.viewBill();
		
		order.cancelOrder(103);
		order.viewBill();
		user.getWalletBalance();
	}

}
