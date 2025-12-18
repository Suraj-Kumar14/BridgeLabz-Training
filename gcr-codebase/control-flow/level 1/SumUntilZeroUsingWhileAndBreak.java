import java.util.Scanner;
//Create a class name SumUntilZeroUsingWhileAndBreak to add the total number till 0. 
public class SumUntilZeroUsingWhileAndBreak
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Create variable total, number and assign to double.
		 double  number, total=0;
		 
		 
	   //Sum of numbers until the user enters 0
		 while(true)
		 {
		    System.out.print("Enter number (0 to stop): ");
		    number=sc.nextDouble();
			if(number<=0)
			{
			 break;
			}
		    total+=number;
		    
		  }
		  System.out.println("Sum is"+total);
		  
		 sc.close();
	}
}