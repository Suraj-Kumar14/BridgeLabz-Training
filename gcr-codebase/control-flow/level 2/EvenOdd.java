import java.util.Scanner;
//Create a class name EvenOdd to indicating the purpose to print even and odd number. 
public class EvenOdd
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Declare int variable number and input from user.
	     System.out.print("Enter number: ");
		 int number=sc.nextInt();
		 
	   //Check user enterd natural number
	     if(number<0)
		 {
		   System.out.println("Please enter a valid number!");
		   return;
		 }
	   //Calculating even and odd.
	     for(int i=1;i<=number;i++)
		 {
		    if(i%2==0)
			{
			   System.out.println(i+" is Even number");
			}
			else
			{
			   System.out.println(i+" is Odd number");
			}
		 }
		  
		 sc.close();
	}
}