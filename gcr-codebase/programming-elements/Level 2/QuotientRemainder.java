//Create a class name QuotientRemainder to indicating the purpose of find quotient and remainder.
import java.util.Scanner;
public class QuotientRemainder
{
	public static void main(String [] args)
	{
		//Creating a Scanner object for taking input from the user.
		  Scanner sc=new Scanner(System.in);
		//Creating two variables number1 and number2.
		  System.out.print("Enter number1: ");
		  int number1 =sc.nextInt();
		  System.out.print("Enter number2: ");
		  int number2 =sc.nextInt();
		    
		// Calculate quotient and remainder. 
		//Create two variable quotient and remainder.
		  double quotient=number1/number2;
		  int remainder=number1%number2;
		  
		//Display quotient and remainder
		  System.out.println("The Quotient is "+quotient+" and Reminder is "+remainder+" of two number is "+number1+" and "+number2);
	
	    sc.close();
	}
}