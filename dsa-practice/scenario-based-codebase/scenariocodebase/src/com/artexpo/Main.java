package com.artexpo;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		ArtManagement art=new ArtManagement();
		int choice=0;
		do {
			System.out.println("------Art Exhibition Registration------");
			System.out.println("1. Artist Registration.");
			System.out.println("2. Sort Artist based on time.");
			System.out.println("3. Display Artist.");
			System.out.println("4. Exit");
			System.out.print("Enter choice: ");
			choice=sc.nextInt();
			sc.nextLine();
			
			switch(choice) 
			{
				case 1:
				{
					System.out.print("Enter Name: ");
					String name=sc.nextLine();
					System.out.print("Enter time: ");
					LocalTime time=LocalTime.parse(sc.nextLine());
					Artist artist=new Artist(name,time);
					art.addArtist(artist);
					break;					
				}
				case 2:
					art.sortArtist();
					break;
				
				case 3:
					art.displayArtist();
					break;
					
				case 4:
					System.out.println("Exiting system..");
					break;
					
				default:
					System.out.println("Invalid choice!");
				
			}				
			
		}while(choice!=4);
		sc.close();
	}
}
