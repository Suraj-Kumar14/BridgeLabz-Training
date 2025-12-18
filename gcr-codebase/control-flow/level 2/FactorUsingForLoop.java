import java.util.Scanner;
//Create a class name FactorUsingForLoop to indicating the purpose of finding factor using for loop. 
public class FactorUsingForLoop
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
	     for(int i=1;i<number;i++)
		 {	 
		   if(number%i==0)
		   {
		     System.out.println(i);
		   }
		 }
		 
		 sc.close();
	}
}