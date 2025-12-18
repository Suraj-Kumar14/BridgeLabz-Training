import java.util.Scanner;
//Create a class name CheckNumberPositiveNegativeZero to indicating the purpose to check the number is positive, negative, or zero. 
public class CheckNumberPositiveNegativeZero
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Create a variable number and take input from user.
		 System.out.print("Enter number: ");
		 int number=sc.nextInt();
		 
		//Check whether the number is positive, negative, and zero. 
		 if(number>0)
		 {
			System.out.println("Positive number");
		 }
		 else if (number<0) 
		 {
		    System.out.println("Negative number");
		 }
		 else
		 {
		    System.out.println("Zero");
		 }
		  
		 sc.close();
	}
}