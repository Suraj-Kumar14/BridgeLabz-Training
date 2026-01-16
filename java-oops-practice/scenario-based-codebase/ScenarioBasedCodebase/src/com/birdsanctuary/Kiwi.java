package com.birdsanctuary;

public class Kiwi extends Bird{
	 public Kiwi(String name) {
	    super(name, "Apteryx mantelli");
   }

   public void birdInfo() {
       System.out.println("Kiwi | ID: " + getBirdId() + " | Name: " + getBirdName());
   }
}