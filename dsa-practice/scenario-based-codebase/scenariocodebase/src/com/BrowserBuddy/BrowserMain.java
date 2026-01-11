package com.BrowserBuddy;

import java.util.Scanner;

public class BrowserMain {

	public static void main(String[] args) {
		
		//create a Scanner object
		Scanner sc=new Scanner(System.in);
		
		//make reference of TabHistoryManager class 
		TabHistoryManager tabHistory=new TabHistoryManager();	
		int choice;
		
		do
		{
			System.out.println("---------Welcome to Browser Buddy---------");
			System.out.println("1. Open new tab");
			System.out.println("2. Visit page");
			System.out.println("3. Go Back");
			System.out.println("4. Go forward");
			System.out.println("5. Show history");
			System.out.println("6. Close tab");
			System.out.println("7. Restore tab");
			System.out.println("8. Exit");
			System.out.print("Enter choice: ");
			choice=sc.nextInt();
			
			switch(choice)
			{
				case 1:
					tabHistory.openTab();
					System.out.println();
					break;
					
				case 2:
					System.out.print("Enter tab index: ");
					int t1=sc.nextInt();
					sc.nextLine();
					System.out.print("Enter URL: ");
					String url=sc.nextLine();
					Tab tab1=tabHistory.getTab(t1);
					if(tab1!=null) {
						tab1.visitPage(url);
					}
					System.out.println();
					break;
					
				case 3:
					System.out.print("Enter tab index: ");
					int t2=sc.nextInt();
					Tab tab2=tabHistory.getTab(t2);
					if(tab2!=null) {
						tab2.Back();
					}
					System.out.println();
					break;
					
				case 4:
					System.out.print("Enter tab index: ");
					int t3=sc.nextInt();
					Tab tab3=tabHistory.getTab(t3);
					if(tab3!=null) {
						tab3.forwardNavigation();
					}
					System.out.println();
					break;
				
				 case 5:
	                 System.out.print("Enter tab index: ");
	                 int t4 = sc.nextInt();
	                 Tab tab4 = tabHistory.getTab(t4);
	                 if (tab4 != null) {
	                  	tab4.showHistory();
	                 }
	                 System.out.println();
                     break;				
				
				case 6:
					System.out.print("Enter tab index: ");
	                int t5 = sc.nextInt();
	                tabHistory.closedTabs(t5);
	                System.out.println();
	                break;
	                  
				case 7:
					tabHistory.restoreTab();
					System.out.println();
					System.out.println();
					break;
									
				case 8:
					 System.out.println("Exiting BrowserBuddy...");
	                 break;

					
				default:
					System.out.println("Invalid choice!");
			}
			
		}while(choice!=8);	
		sc.close();
	}
}
