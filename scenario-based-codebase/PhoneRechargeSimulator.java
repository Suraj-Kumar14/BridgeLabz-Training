import java.util.Scanner;
public class PhoneRechargeSimulator{
	public static void main(String[] args){
	//create a Scanner object
	Scanner sc=new Scanner(System.in);
	double balance=0;
	char choice;
	
	do{
		System.out.println("\nChoose Mobile Operator:");
		System.out.println("1.Airtel \n2.Jio\n3.VI\n");
		System.out.print("Enter choice:");
		int operator=sc.nextInt();
		
		switch(operator)
		{
			case 1: 
			{
				System.out.println("Rs349: 2GB/day, Unlimited Calls, 100 SMS, Unlimited 5G, Xstream Play, Apple Music.");
				System.out.println("Rs449: 3GB/day, Unlimited Calls, 100 SMS, OTT Access, Unlimited 5G.");
				System.out.println("Rs598: 2GB/day + Netflix Basic, Hotstar, Zee5, Xstream, Unlimited 5G.");
				System.out.println("Rs3599: 2GB/day, Unlimited Calls, SMS, Full-year OTT access.");
				System.out.print("Enter recharge amount: ");
		        double amount=sc.nextDouble();
		        balance+=amount;
				break;
			}
			case 2:
			{
				System.out.println("Current Rs399 Plan: Often a 28-day validity plan, potentially with 2GB or 2.5GB daily data (True 5G) + calls/SMS + Jio apps. ");
				System.out.println("For 84 Days (Alternative): The Rs395 plan offers 84 days but with limited data (6GB total), ideal for low data users. ");
				System.out.print("Enter recharge amount: ");
				double amount=sc.nextDouble();
				balance+=amount;
				break;
			}
			case 3:
			{
				System.out.println("you can get 84-day validity with plans like the Rs395 plan (less data, 6GB total) or higher-priced combo plans");
				System.out.print("Enter recharge amount: ");
				double amount=sc.nextDouble();
				balance+=amount;
				break;
			}
			default:
			{
				System.out.println("Invalid Operator.No offer applied.");
			}
		}
		//show updated balance
		System.out.println();
		System.out.println("Your Current recharge of amount: rs"+balance);
		
		//Ask for another recharge
		System.out.println("Do you want to recharge again? (Y/N): ");
		choice=sc.next().toUpperCase().charAt(0);
      }while(choice=='Y');
	  
	  System.out.println("\nThank you for using phone recharge Simulator");
	  sc.close();
    }
}	
	