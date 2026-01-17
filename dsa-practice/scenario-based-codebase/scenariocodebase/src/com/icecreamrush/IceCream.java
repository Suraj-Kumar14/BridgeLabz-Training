package com.icecreamrush;

public class IceCream {
	private String name;
	private int popularity;
	
	public IceCream(String name, int popularity) {
		this.name = name;
		this.popularity = popularity;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPopularity() {
		return popularity;
	}
	
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public String toString() {
		return "IceCream name: "+name+" || popularity: "+popularity;
	}
}
