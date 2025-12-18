import java.util.Scanner;
//Create a class name FizzBuzzUsingWhileLoop to indicating the purpose to print multiple of 3 print Fizz instead of number and multiple of 5 print FizzBuzz. 
public class FizzBuzzUsingWhileLoop
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Declare a int variable number and take input from user.	   
		 System.out.print("Enter number: ");
		 int number=sc.nextInt();
	   //Check for positive integer
		 if(number<1)
		 {
		   System.out.println("Please enter a positive number!");
		   return;
		 }
		 
	   //Iterate while loop and display result
	     int i=1;
	     while(number>=i)
		 {
		   if (i%3==0 && i%5==0)
		   {
		   System.out.println("FizzBuzz");
		   }
		   else if (i%3==0)
		   {
		   System.out.println("Fizz");
		   }
		   else if (i%5==0)
		   {
		   System.out.println("Buzz");
		   }
		   else 
		   {
		   System.out.println(i);
		   }
		   i++;
		 }
		 sc.close();
	}
}