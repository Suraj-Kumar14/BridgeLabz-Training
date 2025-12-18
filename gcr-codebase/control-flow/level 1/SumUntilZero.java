import java.util.Scanner;
//Create a class name SumUntilZero to add the total number till 0. 
public class SumUntilZero
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Create variable total, number and assign to double.
		 double  number, total=0;
		 
		 
	   //Sum of numbers until the user enters 0
		 System.out.print("Enter number (0 to stop): ");
		 number=sc.nextDouble();
		 while(number!=0)
		 {
		    total+=number;
		    System.out.print("Enter number (0 to stop): ");
		    number=sc.nextDouble();
		  }
		  System.out.println("Sum is"+total);
		  
		 sc.close();
	}
}