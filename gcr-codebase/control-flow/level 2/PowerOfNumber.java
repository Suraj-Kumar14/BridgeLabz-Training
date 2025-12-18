import java.util.Scanner;
//Create a class name PowerOfNumber to find the power of number. 
public class PowerOfNumber
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Declare two int variable number,power and take input from user.	   
		 System.out.print("Enter number: ");
		 int number=sc.nextInt();
		 System.out.print("Enter power: ");
		 int power=sc.nextInt();
	   
	   //Calculate result
	     int result=1;
		 if(number>0)
		 {
	         for(int i=1;i<=power;i++)
		     {	 
		       result*=number;
		     } 
		 } 
		 else
		 {
		   System.out.print("Please enter the positive number!");
		 }
		 
	   //Display result	 
	     System.out.print(result);
		 
		 sc.close();
	}
}