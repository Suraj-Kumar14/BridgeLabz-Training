package com.icecreamrush;

public class Main {

	public static void main(String[] args) {
		
		IcecreamManagement iceCream=new IcecreamManagement();
		iceCream.addIcecream(new IceCream("vanilla",6));
		iceCream.addIcecream(new IceCream("chocolate",5));
		iceCream.addIcecream(new IceCream("Strawberry",7));
		iceCream.addIcecream(new IceCream("Butterscotch",9));
		iceCream.addIcecream(new IceCream("cornatto",8));
		iceCream.addIcecream(new IceCream("Coffee",4));
		iceCream.addIcecream(new IceCream("Mango",5));
		
		System.out.println("Before sorting..");
		iceCream.showIceCream();
		
		iceCream.sortIceCream();
		System.out.println("After sorting..");
		iceCream.showIceCream();
		
	}

}
