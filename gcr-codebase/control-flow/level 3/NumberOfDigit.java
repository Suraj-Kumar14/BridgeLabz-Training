import java.util.Scanner;
//Create a class name NumberOfDigit to indicating the purpose of to find the number of digit. 
public class NumberOfDigit
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Take Number as input.	   
		 System.out.print("Enter number: ");
		 int number=sc.nextInt();
	   
	   //Check number of digit.
		 int digit=0;
		 while(number!=0)
		 {
		   number/=10;
		   digit++;
		 }	
		 System.out.println("number of digit is "+ digit);
		 
		 sc.close();
	}
}