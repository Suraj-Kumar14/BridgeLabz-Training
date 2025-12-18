import java.util.Scanner;
//Create a class name SumOfNaturalNumber is used to add the total n natural number. 
public class SumOfNaturalNumber
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Create variable sumWhile, number and assign to int.
		 int number, sumWhile=0;
		 
		 
	   //Sum of all natural numbers using while loop.
	     System.out.print("Enter number: ");
		 number=sc.nextInt();
	   //Sum using formula n*(n+1)/2.
		  int sumFormula = number*(number+1)/2;
		 if(number<=0)
		 {
		    System.out.println("Please enter a valid natural number: ");
			return;
		 }
		 while(number>0)
		 {
		    sumWhile+=number;
			number--;
		 }
		
		 //Display result 
		  System.out.println("Sum using while loop "+sumWhile);
		  System.out.println("Sum using formula "+ sumFormula);
		  
		 //Compare results
		 if(sumFormula==sumWhile)
		 {
		    System.out.println("Both results are correct and equal.");
		 }
		 else
		 {
		   System.out.println("Both results are not equal.");
		 }
		  
		 sc.close();
	}
}