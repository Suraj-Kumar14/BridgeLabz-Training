//Create a class name SumOfNaturalNumber to calculate the sum of first n natural number using recursive method
import java.util.Scanner;
public class SumOfNaturalNumber
{
	//Create method recursiveSum
	public static int recursiveSum(int number)
	{
		if(number==0){
			return 0;
		}
		return number+recursiveSum(number-1);
	}

	//Create method formulaSum
	public static int formulaSum(int number)
	{
		return number*(number+1)/2;
	}

	//Create main method
	public static void main(String [] args)
	{
		//Create a Scanner object
		Scanner sc=new Scanner(System.in);
		//Take input
		System.out.print("Enter Positive number: ");
		int number=sc.nextInt();
		//Check Natural number
		if(number<=0){
			System.out.println("Invalid Number! Please enter a natural number.");
		}
		else
		{
			int sumByRecursion=recursiveSum(number);
			int sumByFormula=formulaSum(number);
		
		    //Display results
		    System.out.print("Sum Using Recursion: "+sumByRecursion);
			System.out.println();
		    System.out.print("Sum Using Formula: "+sumByFormula);
			System.out.println();
		
		    //Compare results
		    if(sumByRecursion==sumByFormula){
		    	System.out.println("Result is correct. Both methods give the same sum");
	    	}
		    else {
			    System.out.println("Result is Incorrect. The sums donot match");
		    }
		}
		sc.close();
	}
}	
	
		
		
		
		
		