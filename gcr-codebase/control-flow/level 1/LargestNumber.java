//Create class LargestNumber to check the largest of three number
import java.util.Scanner;
public class LargestNumber
{
	public static void main	(String [] args)
	{
	  //create Scanner object for taking input
	    Scanner sc =new Scanner(System.in);
	  //Create three variable and take input from user.
	    System.out.print("Enter first number: ");
		int first=sc.nextInt();
		System.out.print("Enter second number: ");
		int second=sc.nextInt();
		System.out.print("Enter third number: ");
		int third=sc.nextInt();
		
		
	//Find largest three of them
	    if(first>second)
		{
		   if(first>third)
		   {
		     System.out.println("Is the first number the largest? Yes");
			 System.out.println("Is the second number the largest? No");
			 System.out.println("Is the third number the largest? No");
		   }
		   else
		   {
		    System.out.println("Is the first number the largest? No");
		    System.out.println("Is the second number the largest? No");
		    System.out.println("Is the third number the largest? Yes");
		   }
		}
		else
		{
		   if(second>third)
		   {
		     System.out.println("Is the first number the largest? No");
		     System.out.println("Is the second number the largest? Yes");
		     System.out.println("Is the first number the largest? No");
		   }
		   else
		   {
		   System.out.println("Is the first number the largest? No");	   
    	   System.out.println("Is the second number the largest? No");
		   System.out.println("Is the third number the largest? Yes");
		   }
	    }
	    sc.close();
	}
}