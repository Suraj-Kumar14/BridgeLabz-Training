import java.util.Scanner;
//Create a class name FizzBuzzArray to indicating the purpose of to print Fizz instead of divisor of 3, print Buzz instead of divisor of 5 and print FizzBuzz instead of divisor of both
public class FizzBuzzArray
{
	public static void main (String [] args)
	{
		//Create a Scanner object
		Scanner sc =new Scanner(System.in);
		//Create a variable number and take input
		System.out.print("Enter natural number: ");
		int number =sc.nextInt();
		//Check for natural number
		if(number<=0)
		{
			System.out.println("Please enter a valid natural number!");
			return;
		}
		//Create a String array
		String []result=new String[number+1];
		for(int i=0;i<=number;i++)
		{
			if(i==0)
			{
			   result[i]="0";
			}
			else if(i%3==0 && i%5==0)
			{
			   result[i]="FizzBuzz";
			}
			else if(i%3==0)
			{
			   result[i]="Fizz";
			}
			else if(i%5==0)
			{
			   result[i]="Buzz";
			}
			else
			{
				result[i]=String.valueOf(i);
			}
		}
		
		//Display result
		for(int i=0;i<=number;i++)
		{
			System.out.println("Position " + i + " = " + result[i]);
		}
		sc.close();
	}
}