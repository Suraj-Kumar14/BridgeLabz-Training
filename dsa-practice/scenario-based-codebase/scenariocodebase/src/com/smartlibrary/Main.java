package com.smartlibrary;

import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		LibraryManagement library=new LibraryManagement();
		
		Scanner sc=new Scanner(System.in);
		int id,choice=0;
		String name;
		do
		{
			System.out.println("------Welcome to Smart Library------");
			System.out.println("1. Add book.");
			System.out.println("2. Borrow book.");
			System.out.println("3. Sort borrow book.");
			System.out.println("4. Display Borrow book.");
			System.out.println("5. Display total book.");
			System.out.println("6. Exit.");
			System.out.print("Enter choice: ");
			choice=sc.nextInt();
			sc.nextLine();
			
			switch(choice)
			{
				case 1:
					System.out.print("Enter Book name: ");
				    name=sc.nextLine();
					System.out.print("Enter Book ID: ");
				    id=sc.nextInt();
					library.addBook(new Book(name,id));
					break;
					
				case 2:
					System.out.print("Enter Book ID: ");
					id=sc.nextInt();
					library.borrowBook(id);
					break;
					
				case 3:
					library.showBorrowBook();
					break;
					
				case 4:
					library.showBorrowBook();
					break;
					
				case 5:
					library.showBook();
					break;
					
				case 6:
					System.out.println("Exiting program..");
					break;
				
				default :
					System.out.println("Invalid choice!");
			}
			
		}while(choice!=6);
		sc.close();
	}
}
