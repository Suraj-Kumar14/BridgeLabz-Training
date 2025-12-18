import java.util.Scanner;
//Create a class name RocketLaunch to count down till 1. 
public class RocketLaunch
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Create a variable number and take input from user.
		 System.out.print("Enter count down value: ");
		 int counter=sc.nextInt();
		 
		//Count Down The Number to launch
		 while(counter>=1)
		 {
		    System.out.println(counter);
			counter--;
		  }
		  System.out.println("Launch");
		  
		 sc.close();
	}
}