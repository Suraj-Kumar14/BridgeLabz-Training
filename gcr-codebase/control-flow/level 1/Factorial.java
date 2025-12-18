import java.util.Scanner;
//Create a class name Factorial to indicating the purpose of find factorial. 
public class Factorial
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Declare variable factorial and initialize to 1, and also declare a another variable number.
		 int factorial=1, number;
	   // Taking input from the user
	     System.out.print("Enter number: ");
		 number=sc.nextInt();
		 
	   //Check user entered positive number
	     if(number<0)
		 {
		   System.out.println("Please enter a valid no!");
		   return;
		 }
	   //Calculating Factorial
		 while(number>0)
		 {
		   factorial*=number;
		   number--;
		  }
		  System.out.println("Factorial is "+factorial);
		  
		 sc.close();
	}
}