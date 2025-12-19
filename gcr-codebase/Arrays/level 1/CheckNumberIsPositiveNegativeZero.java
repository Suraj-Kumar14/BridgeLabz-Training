import java.util.Scanner;
//Create a class name CheckNumberIsPositiveNegativeZero to indicating the purpose to check whether the number is positive, negative or zero 
public class CheckNumberIsPositiveNegativeZero
{
	public static void main(String [] args)
	{
	   
	    //Create a Scanner object for taking input from user
		Scanner sc=new Scanner(System.in);
	    //Declare a array of size 5
		int []numbers=new int [5];
		//Take input 
		for(int i=0;i<numbers.length;i++)
		{
			System.out.print("Enter number: ");
			numbers[i]=sc.nextInt();
		}
		System.out.println();
		
		//Check number is positive
		for(int i=0;i<numbers.length;i++)
		{
			if(numbers[i]>0)
			{
				if(numbers[i]%2==0)
				{
				    System.out.println("Even number");
				}
				else
				{
			        System.out.println("Odd number");
			    }
			}
		    else if(numbers[i] <0)
			{
				System.out.println("Negative number");
			}
			else
		    {
				System.out.println("Zero");
			}
		}	
		if(numbers[0] <numbers[4])
		{				
		    System.out.println("First number is less");
		}
	    else if(numbers[0] >numbers[4])
		{
			System.out.println("First number is greater");
		}
		else
	    {
			System.out.println("Both are equal");
	    }	
		
	   sc.close();
	}
}