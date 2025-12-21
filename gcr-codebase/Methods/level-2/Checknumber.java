//Create a class name Checknumber to indicating the purpose of to check number is positive and negative after that it check for even odd
import java.util.Scanner;
public class Checknumber
{
	//method to check number is positive or negative
	public static boolean isPositive(int number)
	{
		return number>=0;
	}
	
	//method to check number is even or odd
	public static boolean isEven(int number)
	{
		return number%2==0;
	}
	
	//method to compare two numbers returns 1 if number1>number2,0 if equal and -1 if number1<number2 
	public static int compare(int number1,int number2)
	{
		if(number1>number2)
		{
			return 1;
		}
		else if (number1==number2)
		{
			return 0;
		} 
		else
		{
			return -1;
		}
	}
		
	public static void main(String []args)
	{
		//Create a Scanner object
		Scanner sc=new Scanner(System.in);
		int[] numbers=new int[5];
		//Taking input for 5 numbers
		System.out.println("Enter 5 numbers-");
		for(int i=0;i<numbers.length;i++)
		{
		    System.out.print("Enter "+(i+1)+" numbers: ");
		    numbers[i]=sc.nextInt();
		}
		for(int i=0;i<numbers.length;i++)
		{
		    if (isPositive(numbers[i]))
		    {
                if (isEven(numbers[i]))
				{
                    System.out.println(numbers[i] + " is Positive and Even");
                } 
				else
				{
                    System.out.println(numbers[i] + " is Positive and Odd");
                }
            } 
			else 
			{
                System.out.println(numbers[i] + " is Negative");
            }
			
        }
		
		//Compare first and last element
		int result = compare(numbers[0], numbers[numbers.length - 1]);
        if (result == 1) {
            System.out.println("First element (" + numbers[0] + ") is greater than Last element (" + numbers[numbers.length - 1] + ")");
        } else if (result == 0) {
            System.out.println("First element (" + numbers[0] + ") is equal to Last element (" + numbers[numbers.length - 1] + ")");
        } else {
            System.out.println("First element (" + numbers[0] + ") is less than Last element (" + numbers[numbers.length - 1] + ")");
        }

        sc.close();
    }
}

