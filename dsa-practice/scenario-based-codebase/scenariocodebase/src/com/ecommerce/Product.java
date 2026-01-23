package com.ecommerce;

public class Product {
	
	private int SKUno;
	private double price;
	private String name;
	Product left,right;
	
	public Product(int SKUno,double price, String name) {
		this.SKUno=SKUno;
		this.price=price;
		this.name=name;
		left=right=null;
	}

	public int getSKUno() {
		return SKUno;
	}

	public void setSKUno(int sKUno) {
		this.SKUno = sKUno;
	}
	
	public void setPrice(double price) {
		this.price=price;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Product [SKUno=" + SKUno + ", name=" + name +", Price="+price+"]";
	}	
	
	
}
