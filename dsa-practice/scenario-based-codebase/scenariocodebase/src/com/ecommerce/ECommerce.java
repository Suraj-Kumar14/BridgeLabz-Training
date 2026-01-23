package com.ecommerce;

public class ECommerce {
	 Product root;
	
	//add product
	public Product insertProduct(Product root,int skuNo,double price,String name) {
		if(root==null) {
			System.out.println("Product added.");
			return new Product(skuNo,price,name);
		}
		
		if(skuNo<root.getSKUno()) {
			root.left=insertProduct(root.left,skuNo,price,name);
		}else if(skuNo>root.getSKUno()) {
			root.right=insertProduct(root.right,skuNo,price,name);
		}else {
			System.out.println("Product already exits.");
		}
		return root;
	}
	
	//update price of product
	public void updateProduct(Product root,int skuNo,double price ) {
		if(root==null) {
			System.out.println("Product not found!");
			return;
		}
		
		if(skuNo==root.getSKUno()) {
			root.setPrice(price);
		}else if(skuNo<root.getSKUno()) {
			updateProduct(root.left,skuNo,price);
		}else {
			updateProduct(root.right,skuNo,price);
		}		
	}
	
	//delete product
//	public Product deleteProduct(Product root,int skuNo) {
//		if(root==null) {
//			return root;
//		}
//		if(skuNo<root.getSKUno()) {
//			root.left=deleteProduct(root.left,skuNo);
//		}else if(skuNo>root.getSKUno()) {
//			root.right=deleteProduct(root.right,skuNo);
//		}else {
//			if(root.left==null) {
//				return root.right;
//			}
//			if(root.right==null) {
//				return root.left;
//			}
//			root.setSKUno(minValue(root.right));
//			root.right=deleteProduct(root.right,root.getSKUno());
//		}
//		return root;
//	}
//	
//	//find minvalue
//	public int minValue(Product root) {
//		while(root.left!=null) 
//			root=root.left;
//			return root.getSKUno();				
//	}
	
	//Search number
	public void search(Product root,int skuNo) {
		if(root==null) {
			System.out.println("Product not found!");
			return;
		}		
		if(skuNo==root.getSKUno()) {
			System.out.println(root);
		}else if(skuNo<root.getSKUno()) {
			search(root.left,skuNo);
		}else {
			search(root.right,skuNo);
		}
	}
	
	//display Product
	public void inorder(Product root) {
		if(root!=null) {
			inorder(root.left);
			System.out.println(root+" ");
			inorder(root.right);
		}
	}
}
