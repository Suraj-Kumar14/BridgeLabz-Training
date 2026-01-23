package com.binarysearchtree.musicapp;

import java.util.Scanner;

public class MusicApp {

		public static void main(String[] args) {		
		
		Scanner sc=new Scanner(System.in);
		MusicOrganizer music=new MusicOrganizer();
		
		while(true) {
			System.out.println("\n-------Music PlayLists-------");
			System.out.println("1. Insert music.\n2. search music.\n3. Show playlist.\n4.Exit.");
			System.out.print("Enter choice: ");
			int choice=sc.nextInt();
			
			switch(choice) {
				case 1:
					System.out.print("Enter music Id: ");
					int id=sc.nextInt();
					sc.nextLine();
					System.out.print("Enter music name: ");
					String name=sc.nextLine();
					music.root=music.insertTrack(music.root,id, name);
					break;
					
				case 2:
					System.out.print("Enter music ID: ");
				    id=sc.nextInt();
					music.searchTrack(music.root,id);
					break;
					
				case 3:
					music.inorder(music.root);
					break;
					
				case 4:					
					System.out.println("Exiting..");
					sc.close();
					System.exit(0);
					
				default: 
					System.out.println("Invalid choice!");
			}
		}
	}

}
