//Create a class name NumberCheckerMethod to find the duck number, Armstrong number, largest and smallest number using method
import java.util.Scanner;
public class NumberCheckerMethod
{
	//method to count of digits
	public static int countDigits(int number)
	{
		int count=0;
		while(number!=0){
			count++;
			number/=10;
		}
		return count;
	}
	
	
	//method to Store the digits of the number in a digits array
	public static int[] storeDigits(int number)
	{
		int temp=number;
		int count=countDigits(number);
		int []digits=new int [count];
		for(int i=count-1;i>=0;i--)
		{
			digits[i]=temp%10;
			temp/=10;
		}
		return digits;
	}
	
	//method to check number is a duck number
	public static boolean isDuck(int [] digits)
	{
		for (int i=0;i<digits.length;i++)
		{
			if(digits[i]==0) {
			return false;
		    }
		}	
		return true;
	}
	
	//method check Armstrong number
	public static boolean isArmstrong(int number)
	{
		int arm=number;
		int rem,sum=0;
		while(number!=0)
		{
			rem=number%10;
			sum+=Math.pow(rem,3);
			number/=10;
		}
		if(sum==arm)
		return true;
		else
		return false;
	}
	
	//method to check largest value
	public static void largestSecondLargest(int []digits)
	{
		int largest=Integer.MIN_VALUE;
		int secondLargest=Integer.MIN_VALUE;
		for(int d:digits)
		{
			if(d>largest)
			{
				secondLargest=largest;
				largest=d;
			}
			else if(d>secondLargest && d!=largest){
				secondLargest=d;
			}
		}
		System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + secondLargest);
	}
	
	
	//method to check smallest value
	public static void smallestSecondSmallest(int []digits)
	{
		int smallest=Integer.MAX_VALUE;
		int secondSmallest=Integer.MAX_VALUE;
		for(int d:digits)
		{
			if(d<smallest)
			{
				secondSmallest=smallest;
				smallest=d;
			}
			else if(d<secondSmallest && d!=smallest){
				secondSmallest=d;
			}
		}
		System.out.println("Smallest: " + smallest);
        System.out.println("Second smallest: " + secondSmallest);
	}
	
				
	public static void main(String[] args)
	{
		//Create a Scanner object
		Scanner sc=new Scanner(System.in);
		//Take number
		System.out.print("Enter number: ");
		int number=sc.nextInt();
		
		//call method countDigits
		System.out.print("The count of digit is: "+countDigits(number));
		System.out.println();
		//call method storeDigits
		int []digits=storeDigits(number);
		
		//call method isDuck
		if(isDuck(digits))
		  System.out.println("The number is a Duck number!");
		else 
		  System.out.println("The number is not a Duck number!");
		
		//call method isArmstrong
		if(isArmstrong(number))
			System.out.print("The number is a Armstrong number!");
		else
			System.out.print("The number is not a Armstrong number!");
		System.out.println();
		//call method largestSecondLargest
		largestSecondLargest(digits);
		
		//call method smallestSecondSmallest
		smallestSecondSmallest(digits);
		
		sc.close();
	}
}
		