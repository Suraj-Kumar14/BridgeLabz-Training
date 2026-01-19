package com.flashdealz;

import java.util.ArrayList;
import java.util.List;

public class ECommerce {
	List<Product>products=new ArrayList<>();
	
	public void addProduct(Product product) {
		products.add(product);
		System.out.println("Product added.");
	}
	
	public void sortProduct() {
		if(products.size()>1) {
			int start=0,end=products.size()-1;
			quickSort(start,end);
			System.out.println("Products are sorted in terms of discount.");
	    }
	}
		
	
	private void quickSort(int start,int end) {
		if(start<end) {
			int pi=partition(start,end);
			quickSort(start,pi-1);
			quickSort(pi+1,end);
		}
	}
	
	private int partition(int start,int end) {
		Product pivot=products.get(end);
		
		int i=start-1;
		
		for(int j=start;j<end;j++) {
			if(products.get(j).getDiscount()<pivot.getDiscount()) {
				i++;
				swap(i,j);
			}
		}
		swap(i+1,end);
		return i+1;
	}
	
	private void swap(int i,int j) {
		Product temp=products.get(i);
		products.set(i, products.get(j));
		products.set(j, temp);
	}
	
	public void showProduct() {
		System.out.println("----------Products details----------");
		if(!products.isEmpty()) {
			for(var prod:products) {
				System.out.println(prod);
			}
		}else {
			System.out.println("No product available!");
		}
		System.out.println();
	}
}
