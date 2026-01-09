package com.artify;

public class User implements IPurchasable{
	private String name;
	private double walletBalance;
	
	
	public User(String name, double walletBalance) {
		this.name = name;
		this.walletBalance = walletBalance;
	}


	public double getWalletBalance() {
		return walletBalance;
	}


	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}


	public String getName() {
		return name;
	}


	@Override
	public void purchase(String title) {
		for(ArtWork works:ArtWork.artList) {
			if(works.getTitle().equals(title)) {
				//check use have amount to buy this or not
				if(works.getPrice()<=walletBalance) {
					double temp = works.getPrice();
					setWalletBalance((walletBalance-temp));
					System.out.println("Art buy success.");
					return;
				}
				else {
					System.out.println("Amout not sufficent to buy");
					return;
				}
			}
		}
		System.out.println("Title not found!");
	}


	@Override
	public void license(String title) {
		for(ArtWork works: ArtWork.artList) {
			if(works.getTitle().equalsIgnoreCase(title)) {
				
				if(works.getPrice()<=walletBalance) {
					setWalletBalance(walletBalance-works.getPrice());
					
					System.out.println("License Approved!");
					return;
				}else {
					System.out.println("Balance not available to make license!");
					return;
				}
			}
		}
		System.out.println("Art Title not found!");
	}
	
}
