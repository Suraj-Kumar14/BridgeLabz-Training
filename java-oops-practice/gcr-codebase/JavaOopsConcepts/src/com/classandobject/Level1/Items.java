package com.classandobject.Level1;

public class Items {
	//declaring the variable for listing items
	  String[] itemCode;
	  String[] itemName;
	  double[] price;
	 
	 //Constructor
	   Items(String[] itemCode,String[] itemName,double[] price){
		 this.itemCode=itemCode;
		 this.itemName=itemName;
		 this.price=price;
	 }
	 
	 //methods to items 
	 public void displayItems(int i) {
		 System.out.println("itemCode: "+itemCode[i]);
		 System.out.println("itemName: "+itemName[i]);
		 System.out.println("Price: "+price[i]);
		 System.out.println("----------------");
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String[] itemName= {"Water Bottle","Rice","Blackboard"};
		 String[] itemCode= {"01AA","01BB","02AA"};
		 double[] price= {500,700,400};
		 Items item=new Items(itemCode,itemName,price);
		 for(int i=0;i<price.length;i++) {
			 item.displayItems(i);
		 }
		 
	}

}
