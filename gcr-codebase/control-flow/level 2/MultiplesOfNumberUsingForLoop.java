import java.util.Scanner;
//Create a class name MultiplesOfNumberUsingForLoop to indicating the purpose of finding multiples number using for loop. 
public class MultiplesOfNumberUsingForLoop
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Declare a int variable number and take input from user.	   
		 System.out.print("Enter number: ");
		 int number=sc.nextInt();
	   
	   //Check positivity
		 if(number>=0 && number<100)
		 {
		   //Calculate and Display factor
	   	     System.out.println("Multiples of number are: ");
	         for(int i=100;i!=0;i--)
		     {	 
		       if(i%number==0)
		       {
		         System.out.println(i);
				 continue;
		       }
		     } 
		 } 
		 else
		 {
		    System.out.println("Please enter positive number and below 100: ");
		 }	
		 
		 sc.close();
	}
}