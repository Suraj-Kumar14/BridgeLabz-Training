//Create a class name CheckDivisible to indicating the purpose of checking number is divisible by 5 or not.
import java.util.Scanner;
public class CheckDivisible
{
	public static void main(String [] args)
	{
	   //Create a Scanner object for take input from the user.
	     Scanner sc=new Scanner(System.in);
	   //Create a variable number and take input from User.
	     System.out.print("Enter Number: ");
		 int number=sc.nextInt();
		 
	   //Check whether number is divisible is by 5 or not.
	     if(number%5==0)
		   System.out.print("Is the number "+number+" divisible by 5? Yes");
		 else
		   System.out.print("Is the number "+number+" divisible by 5? No");
	
	    sc.close();
	}
}