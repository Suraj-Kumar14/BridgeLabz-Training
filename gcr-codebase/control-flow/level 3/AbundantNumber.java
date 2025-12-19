import java.util.Scanner;
//Create a class name AbundantNumber to indicating the purpose of to Check is the number Abundant. 
public class AbundantNumber
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Take Number as input.	   
		 System.out.print("Enter number: ");
		 int number=sc.nextInt();

	   
	   //Calculate sum of divisor.
		 int sum=0;
		 for(int i=1;i<number;i++)
		 {
		   if(number%i==0)
		   {
		      sum+=i;
		   }	
		 }
		 
		 
	   //Check Harshad Number	
		if(sum>number)
		{
		    System.out.println(number+" is a Abundant number");
		}
		else
		{
		    System.out.println(number+" is not a Abundant number");
		}
		sc.close();
	}
}