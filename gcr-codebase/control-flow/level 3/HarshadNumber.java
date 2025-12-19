import java.util.Scanner;
//Create a class name HarshadNumber to indicating the purpose of to Check is the number Harshad. 
public class HarshadNumber
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Take Number as input.	   
		 System.out.print("Enter number: ");
		 int number=sc.nextInt();
		 int harshad=number;
	   
	   //Check number of digit.
		 int sum=0;
		 while(number!=0)
		 {
		   int rem=number%10;
		   sum+=rem;
		   number/=10;
		 }	
		 
	   //Check Harshad Number	
		if(harshad%sum==0)
		{
		    System.out.println(harshad+" is Harshad number");
		}
		else
		{
		    System.out.println(harshad+" is not Harshad number");
		}
		 sc.close();
	}
}