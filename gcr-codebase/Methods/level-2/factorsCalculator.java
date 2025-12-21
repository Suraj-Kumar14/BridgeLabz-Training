//Create a class name factorsCalculator to indicating the purpose of to find factor of given number, the sum, sum of square, and the product of factor by making the method
import java.util.Scanner;
public class factorsCalculator
{
	//Create method findFactors
	public static int[] findFactors(int number)
	{	
		int count=0;
		//loop for count factor
		for(int i=1;i<number;i++)
		{
			if(number%i==0){
			count++;
			}
		}
		int []factors=new int[count];
		int index=0;
		//loop for store factor
		for(int i=1;i<number;i++){
			if(number%i==0){
			factors[index]=i;
			index++;
			}
		}
		return factors;
	}
	
	//Create method to find the sum of factor
	public static int sumOfFactors(int[] factors)
	{
		//Declare sum variable and initialize to zero
		int sum=0;
		for(int i=0;i<factors.length;i++)
		{
			sum+=factors[i];
		} 
		return sum;
	}
	
	//Create a method factorProduct to find the product of a factor
	public static int factorProduct(int []factors)
	{
		int product=1;
		for(int i=0;i<factors.length;i++)
		{
			product*=factors[i];
		}
		return product;
	}		
		
	
	//Create a method sumOfSquare to find the sum of square of factor
	public static int sumOfSquare(int []factors)
	{
		int sumOfSquareOfFactor=0;
		for(int i=0;i<factors.length;i++)
		{
			sumOfSquareOfFactor+=Math.pow(factors[i],2);
		}
		return sumOfSquareOfFactor;
	}
	
	//Create main method
	public static void main(String []args)
	{
		//Create Scanner object
		Scanner sc=new Scanner(System.in);
		//Take user input
		System.out.print("Enter Number: ");
		int number=sc.nextInt();
		int []factors=findFactors(number);
		
		//Display factor
		System.out.print("Fators of "+number+" are: ");
		for(int i=0;i<factors.length;i++)
		{
			System.out.print(factors[i]+" ");
		}
		System.out.println();
		System.out.print("Sum of factors are: "+sumOfFactors(factors));
		System.out.println();
		System.out.print("Product of Factors are: "+factorProduct(factors));
		System.out.println();
		System.out.print("Sum of square of Factors are: "+sumOfSquare(factors));
		
		sc.close();
	}
}	
		
	