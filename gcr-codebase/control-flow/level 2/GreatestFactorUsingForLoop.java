import java.util.Scanner;
//Create a class name GreatestFactorUsingForLoop to indicating the purpose of finding greatest factor using for loop. 
public class GreatestFactorUsingForLoop
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Declare a int variable number and take input from user.	   
		 System.out.print("Enter number: ");
		 int number=sc.nextInt();
		 int greatestFactor=1;
	     
		 
	   //Calculate and Display factor
	     for(int i=number-1;i!=1;i--)
		 {	 
		   if(number%i==0)
		   {
		     greatestFactor=i;
			 break;
		   }
		 }
		 System.out.println("The greatest factor of "+number+" is "+greatestFactor);
		 
		 sc.close();
	}
}