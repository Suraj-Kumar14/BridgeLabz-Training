import java.util.Scanner;
//Create a class name CountDownUsingForLoop to count down till 1. 
public class CountDownUsingForLoop
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Create a variable number and take input from user.
		 System.out.print("Enter count down value: ");
		 int counter=sc.nextInt();
		 
		//Count Down The Number to launch
		 for(int i=counter;i>=1;i--)
		 {
		    System.out.println(counter);
		  }
		  System.out.println("Launch");
		  
		 sc.close();
	}
}