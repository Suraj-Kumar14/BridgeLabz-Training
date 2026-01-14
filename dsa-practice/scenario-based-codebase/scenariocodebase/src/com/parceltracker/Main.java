package com.parceltracker;

public class Main {
	
	public static void main(String[] args) {
        ParcelTracker parcel = new ParcelTracker();

        // Standard stages
        parcel.addStage("Packed");
        parcel.addStage("Shipped");
        parcel.addStage("In Transit");
        parcel.addStage("Delivered");

        // Add custom checkpoint
        parcel.insertCheckpoint("In Transit", "Warehouse Check");

        // Track parcel
        parcel.trackParcel();

        // Check if parcel is lost
        if (parcel.isParcelLost()) {
            System.out.println("Parcel is missing!");
        } else {
            System.out.println("Parcel is being tracked.");
        }
    }


}
