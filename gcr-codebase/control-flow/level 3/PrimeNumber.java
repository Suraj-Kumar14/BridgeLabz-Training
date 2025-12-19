import java.util.Scanner;
//Create a class name PrimeNumber to indicating the purpose of to determine whether the number is prime number. 
public class PrimeNumber
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Take Number as input.	   
		 System.out.print("Enter number: ");
		 int number=sc.nextInt();
	   
	   //Check prime number
		 boolean isPrime=true;
		 for(int i=2;i<number;i++)
		 {
	        if(number%i==0)
		    {
			   isPrime=false;
			   break;
			}  	 
		}	
	    if(isPrime==true)
		{
		   System.out.println(number+" is a prime number!.");
		}  	   
		else
		{
		   System.out.println(number+" is not a prime number!.");
		}  	
		 sc.close();
	}
}