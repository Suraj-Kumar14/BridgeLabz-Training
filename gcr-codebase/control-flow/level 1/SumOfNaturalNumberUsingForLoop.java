import java.util.Scanner;
//Create a class name SumOfNaturalNumberUsingForLoop is used to add the total n natural number. 
public class SumOfNaturalNumberUsingForLoop
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Create variable sumFor, number and assign to int.
		 int number, sumFor=0;
		 
	     System.out.print("Enter number: ");
		 number=sc.nextInt();
	   //Sum using formula n*(n+1)/2.
		  int sumFormula = number*(number+1)/2;
		 if(number<=0)
		 {
		    System.out.println("Please enter a valid natural number: ");
			return;
		 }
		 //Sum of all natural numbers using for loop.
		 for(int i=number;i>0;i--)
		 {
		    sumFor+=i;			
		 }
		
		 //Display result 
		  System.out.println("Sum using for loop "+sumFor);
		  System.out.println("Sum using formula "+ sumFormula);
		  
		 //Compare results
		 if(sumFormula==sumFor)
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