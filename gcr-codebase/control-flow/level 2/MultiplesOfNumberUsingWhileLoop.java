import java.util.Scanner;
//Create a class name MultiplesOfNumberUsingWhileLoop to indicating the purpose of finding multiples number using while loop. 
public class MultiplesOfNumberUsingWhileLoop
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Declare a int variable number and take input from user.	   
		 System.out.print("Enter number: ");
		 int number=sc.nextInt();
	   
	   //Check positivity
		 if(number>=0 && number<100)
		 {
		   //Calculate and Display multiples 
	   	     System.out.println("Multiples of number are: ");
			 int counter=number-1;
	         while(counter>1)
		     {	 
		       if(number%counter==0)
		       {
		         System.out.println(counter);
		       }
			   counter--;
		     } 
		 } 
		 else
		 {
		    System.out.println("Please enter positive number and below 100: ");
		 }	
		 
		 sc.close();
	}
}