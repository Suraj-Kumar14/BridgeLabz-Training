import java.util.Scanner;
//Create a class name FactorUsingWhileLoop to indicating the purpose of finding factor using While loop. 
public class FactorUsingWhileLoop
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Declare a int variable number and take input from user.	   
		 System.out.print("Enter number: ");
		 int number=sc.nextInt();
	   
	   //Check positivity
		 if(number<0)
		 {
		    System.out.println("Please enter positive number: ");
			return;
		 }
		 
	   //Calculate and Display factor
	     System.out.println("Factors of "+number+" are: ");
		 int counter=1;
	     while(number>counter)
		 {	 
		   if(number%counter==0)
		   {
		     System.out.println(counter);
		   }
		   counter++;
		 }
		 
		 sc.close();
	}
}