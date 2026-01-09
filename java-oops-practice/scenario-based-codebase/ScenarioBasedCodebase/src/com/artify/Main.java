package com.artify;

public class Main {

	public static void main(String[] args) {
		ArtWork art = new PrintArt("hourse Run","Bad Bunny",24500,"Normal");
		
		ArtWork art1 = new DigitalArt("Gods Truth","Adam christ",10000,"Normal");
		
		ArtWork art2 = new PrintArt("Die With A Smile","British ellie",12000,"Exclusive");
		
		art.addArts(art);
		art1.addArts(art1);
		art2.addArts(art2);
		
		
		art.viewArts();
		//buyer 
		User user = new User("Suraj",50000);
		
		
		System.out.println("Available balance:"+user.getWalletBalance());
		
		user.purchase("Gods Truth");
		
		System.out.println(user.getWalletBalance());
		user.license("Gods Truth");
		
		
	}
}
