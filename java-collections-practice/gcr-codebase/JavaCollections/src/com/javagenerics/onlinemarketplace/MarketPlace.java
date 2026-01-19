package com.javagenerics.onlinemarketplace;

public class MarketPlace {

	public static void main(String[] args) {
		
		Product<BookCategory>book=new Product<>("Java programming",500,new BookCategory());
		Product<ClothingCategory>cloths=new Product<>("T-shirt",800,new ClothingCategory());
		Product<GadjetCategory>gedjet=new Product<>("Smartphone",15000,new GadjetCategory());
		
		DiscountService.applyDiscount(book, 10);
		DiscountService.applyDiscount(cloths, 20);
	    DiscountService.applyDiscount(gedjet, 5);
	    
	    ProductCatalog catalog=new ProductCatalog();
	    catalog.addProduct(book);
	    catalog.addProduct(cloths);
	    catalog.addProduct(gedjet);
	    catalog.displayCatalog();
	}

	

}
