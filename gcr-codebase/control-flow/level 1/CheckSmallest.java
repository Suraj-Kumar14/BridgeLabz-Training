//Create a class name CheckSmallest to Check is the first number is smallest.
import java.util.Scanner;
public class CheckSmallest
{
	public static void main(String [] args)
	{
		//Create a Scanner class to take input from the user.
		Scanner sc =new Scanner(System.in);
		//Create three variable name number1, number2, amd number3.
		 System.out.print("Enter first no: ");
		 int number1=sc.nextInt();
		 System.out.print("Enter second no: ");
		 int number2=sc.nextInt();
		 System.out.print("Enter third no: ");
		 int number3=sc.nextInt();
		 
		//Check first number is the smallest number.
		 if((number1<number2) && (number1<number3)){
		  System.out.println("Is the first number the smallest? Yes");
		  }
		  else
		  {
		  System.out.println("Is the first number the smallest? No");
		  }
		  
		  sc.close();
	}
}
		  