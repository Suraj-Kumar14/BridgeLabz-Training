package com.birdsanctuary;

import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		BirdSanctuary owner = new BirdSanctuary();
		
		//here work start
		while(true){
			System.out.println("\n---------------Choose Option--------------");
			System.out.println("Add New Birds-> please enter 'A' : ");
			System.out.println("Search Birds-> please enter 'S' : ");
			System.out.println("Display All Birds-> enter 'V': ");
			System.out.println("Remove Birds-> enter 'R': ");
			System.out.println("View Birds Report-> enter 'T': ");
			System.out.println("For exit quiz -> enter 'E' :");
			System.out.println("--------------------------------------------");
			
			char c = sc.next().charAt(0);
			c = Character.toUpperCase(c);
			sc.nextLine();
			
			if(c=='E'){
				System.out.println("Thanks for use our service! Please come again");
				break;
			}
			
			switch(c){
				case 'A':
					addBirdsInput();
					break;
				case 'S':
					System.out.println("Enter bird Id: ");
					int searchId = sc.nextInt();
					owner.searchBirds(searchId);
					break;
				case 'V':
					owner.displayAllBirds();
					break;
				case 'R':
					System.out.println("Enter bird Id: ");
					int removeId = sc.nextInt();
					owner.removeBirds(removeId);
					break;
				case 'T':
					owner.report();
					break;
				default:
					System.out.println("Invalid input!");
			}
		}
	}
	
	//take input to add birds
	public static void addBirdsInput() {
		BirdSanctuary owner = new BirdSanctuary();
		
		System.out.println("Enter Bird Name: ");
		String birdName = sc.nextLine();
		
		System.out.println("-------Choose Bird To Add-------");
		System.out.println("Duck -> enter 'D': ");
		System.out.println("Eagle -> enter 'E': ");
		System.out.println("Penguin -> enter 'P': ");
		System.out.println("Kiwi -> enter 'K': ");
		
        char c = Character.toUpperCase(sc.next().charAt(0));
        sc.nextLine();

        Bird bird = null;

        switch (c) {
            case 'D': bird = new Duck(birdName); break;
            case 'E': bird = new Eagle(birdName); break;
            case 'P': bird = new Penguin(birdName); break;
            case 'K': bird = new Kiwi(birdName); break;
            default:
                System.out.println("Invalid bird type");
                return;
        }
       owner.addBirds(bird);
	}
}