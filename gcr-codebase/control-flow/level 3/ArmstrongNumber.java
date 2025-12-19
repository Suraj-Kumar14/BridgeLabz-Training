import java.util.Scanner;
//Create a class name ArmstrongNumber to indicating the purpose of to determine whether the number is armstrong. 
public class ArmstrongNumber
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Take Number as input.	   
		 System.out.print("Enter number: ");
		 int number=sc.nextInt();
	   
	   //Check Armstrong number
		 int originalNumber=number;
		 int sum=0;
		 while(originalNumber!=0)
		 {
	       int rem=originalNumber%10; 	 
		   sum+=Math.pow(rem,3);
		   originalNumber/=10;
		 }	
	    if(number==sum)
		{
		   System.out.println(number+" is a Armstrong number!.");
		}  	   
		else
		{
		   System.out.println(number+" is not a Armstrong number!.");
		}  	
		 sc.close();
	}
}