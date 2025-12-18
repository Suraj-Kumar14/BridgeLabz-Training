import java.util.Scanner;
//Create a class name GreatestFactorUsingWhileLoop to indicating the purpose of finding greatest factor using While loop. 
public class GreatestFactorUsingWhileLoop
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Declare a int variable number and take input from user.	   
		 System.out.print("Enter number: ");
		 int number=sc.nextInt();
		 int greatestFactor=1;
	   
	   //Check positivity
		 if(number<0)
		 {
		    System.out.println("Please enter positive number: ");
			return;
		 }
		 
	   //Calculate and Display factor
		 int counter=number-1;
	     while(counter!=1)
		 {	 
		   if(number%counter==0)
		   {
		     greatestFactor=counter;
			 break;
		   }
		   counter--;
		 }
		 System.out.println("The greatest factor of "+number+" is "+greatestFactor);
		 
		 sc.close();
	}
}