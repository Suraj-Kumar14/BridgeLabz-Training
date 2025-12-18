import java.util.Scanner;
//Create a class name YoungestTallest to indicating the purpose to find the youngest and tallest of three friend. 
public class YoungestTallest
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Declare six int variable amarAge, akbarAge, anthonyAge, amarHeight, akbarHeight, anthonyHeight and take input from user.	   
		 System.out.print("Enter Amar age: ");
		 int amarAge =sc.nextInt();
		 System.out.print("Enter Akbar age: ");
		 int akbarAge =sc.nextInt();
		 System.out.print("Enter Anthony age: ");
		 int anthonyAge =sc.nextInt();
		 System.out.print("Enter Amar Height: ");
		 int amarHeight =sc.nextInt();
		 System.out.print("Enter Akbar Height: ");
		 int akbarHeight =sc.nextInt();
		 System.out.print("Enter Anthony Height: ");
		 int anthonyHeight =sc.nextInt();
		 
	   //Find the youngest friend and display 
         if (amarAge<akbarAge)
		 {
		     if(amarAge<anthonyAge) 
		     {
         		   System.out.println("Amar is the youngest friend");
		     }
		     else 
		     {
		           System.out.println("Anthony is the youngest friend");
		     }
         }
		 else
         {		 
		     if(akbarAge<anthonyAge)
		     {
		         System.out.println("Akbar is the youngest friend");
		     }
		     else 
		     {
		        System.out.println("Anthony is the youngest friend");
		     }
		   
		 }
		 
	   //Find the tallest friend and display
		  if (amarHeight>akbarHeight)
		 {
		     if(amarHeight>anthonyHeight) 
		     {
         		   System.out.println("Amar is the tallest friend");
		     }
		     else 
		     {
		           System.out.println("Anthony is the tallest friend");
		     }
         }
		 else
         {		 
		     if(akbarHeight>anthonyHeight)
		     {
		         System.out.println("Akbar is the tallest friend");
		     }
		     else 
		     {
		        System.out.println("Anthony is the tallest friend");
		     }
		   
		 }
		 sc.close();
	}
}