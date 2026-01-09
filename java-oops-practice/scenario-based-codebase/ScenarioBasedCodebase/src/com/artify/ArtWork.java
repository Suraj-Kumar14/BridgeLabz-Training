package com.artify;
import java.util.*;

public class ArtWork {
	private String title;
	private String artist;
	private double price;
	private String licenseType;
	private String artType;
	
	static List<ArtWork> artList = new ArrayList<>();
	
	public ArtWork(String title, String artist, double price, String licenseType,String artType) {
		this.title = title;
		this.artist = artist;
		this.price = price;
		this.licenseType = licenseType;
		this.artType = artType;
	}
	
	public String getTitle() {
		return title;
	}
	public String getArtist() {
		return artist;
	}
	public double getPrice() {
		return price;
	}
	public String getLicenseType() {
		return licenseType;
	}
	public String getArtType() {
		return artType;
	}
	//add art
	public void addArts(ArtWork newWork) {
		artList.add(newWork);
		System.out.println("Art added!");
	}
	
	//remove art
	public void removeArts(ArtWork newWork) {
		if(artList.contains(newWork)) {
			artList.remove(newWork);
			System.out.println("Art removed");
			return;
		}
		System.out.println("Art not found!");
	}
	
	//view art
	public void viewArts() {
		for(ArtWork works:artList) {
			System.out.println("-----------Art List------------");
			System.out.println("title: "+works.getTitle());
			System.out.println("Artist name: "+works.getArtist());
			System.out.println("Art Price: "+works.getPrice());
			System.out.println("Art license type: "+works.getLicenseType());
			System.out.println("Art type: "+works.getArtType());
			System.out.println("------------------------------");
			System.out.println();
		}
	}
}
