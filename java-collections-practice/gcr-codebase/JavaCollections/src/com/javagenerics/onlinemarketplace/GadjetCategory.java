package com.javagenerics.onlinemarketplace;

public class GadjetCategory implements Category{

	@Override
	public String getCategoryName() {
		return "Gedjet";
	}

	@Override
	public String toString() {
		return getCategoryName();
	}

}
