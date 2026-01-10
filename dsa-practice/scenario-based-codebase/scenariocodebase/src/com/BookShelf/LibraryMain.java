package com.BookShelf;

import java.util.Scanner;

public class LibraryMain {
	public static void main(String [] args) {
		
		Library library=new Library();
		
		Scanner sc=new Scanner(System.in);
		boolean check=false;
		
		do {
			System.out.println("----Welcome to BookShelf library----");
			System.out.println("\nEnter 1 for Add Book:");
			System.out.println("Enter 2 for Borrow Book:");
			System.out.println("Enter 3 for Return Book:");
			System.out.println("Enter 4 for Show Book:");
			System.out.println("Enter 5 for Exit:");
			int n=sc.nextInt();
			sc.nextLine();
			
			switch(n) {
				case 1:
				{
					System.out.print("\nEnter Genre: ");
					String genre=sc.nextLine();
					System.out.print("Enter Book name: ");
					String title=sc.nextLine();
					System.out.print("Enter Author name:");
					String author=sc.nextLine();
					Book book=new Book(title,author);
					library.addBook(genre,book);
					break;
				}
				case 2:
				{
					System.out.print("\nEnter Genre: ");
					String genre=sc.nextLine();
					System.out.print("Enter Title: ");
					String title=sc.nextLine();
					library.borrowBook(genre, title);
					break;
				}
				case 3:
				{
					System.out.print("\nEnter Genre: ");
					String genre=sc.nextLine();
					System.out.print("Enter Book name: ");
					String title=sc.nextLine();
			
					library.returnBook(genre,title );
					break;
				}
				case 4:
				{
					library.displayCatalog();
					break;
				}
				case 5:
				{
					check=true;
				}
			}
		}while(check==false);		
		sc.close();
	}
}
