//Create a class name CheckNatural to indicating the purpose of checking natural number.
import java.util.Scanner;
public class CheckNatural
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
		 //Create a variable number and take input from user.
		 System.out.print("Enter no: ");
		 int number=sc.nextInt();
		 
	   // Calculate natural number.
	     if(number>=0)
		 {
		    int sum=0;
		    for(int i=0; i<=number;i++)
		    {
		        sum+=i;
		    }
			System.out.println("The sum of "+number+" natural numbers is "+sum);
		 }
		 else
		 {
		 System.out.println("The number "+number+" is not a natural number");
		 }
		 
		 sc.close();
	}
}
		 