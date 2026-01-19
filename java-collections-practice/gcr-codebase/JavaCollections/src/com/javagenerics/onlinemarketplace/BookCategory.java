package com.javagenerics.onlinemarketplace;

public class BookCategory implements Category{

	@Override
	public String getCategoryName() {		
		return "Book";
	}
	
	@Override
    public String toString() {
        return getCategoryName();
    }
	
}
