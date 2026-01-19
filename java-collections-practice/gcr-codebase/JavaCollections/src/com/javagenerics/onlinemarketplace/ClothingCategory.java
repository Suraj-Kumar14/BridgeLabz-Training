package com.javagenerics.onlinemarketplace;

public class ClothingCategory implements Category{

	@Override
	public String getCategoryName() {	
		return "Cloth";
	}

	@Override
	public String toString() {
		return  getCategoryName();
	}
	
}
