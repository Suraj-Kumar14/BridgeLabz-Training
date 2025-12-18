import java.util.Scanner;
//Create a class name PowerOfNumberUsingWhileLoop to find the power of number. 
public class PowerOfNumberUsingWhileLoop
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
	   
	   //Initialize result and counter
	     int result=1,counter=0;
		 while(counter<power)
		 {
		    result*=number;
			counter++;
		 }
		 
	   //Display result	 
	     System.out.print(result);
		 
		 sc.close();
	}
}