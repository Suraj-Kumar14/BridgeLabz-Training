import java.util.Scanner;
//Create a class name OddEvenSum to indicating the purpose to add the odd number in odd array and even number in even array.  
public class OddEvenArrays
{
	public static void main(String [] args)
	{	   
	    //Create a Scanner object for taking input from user
		Scanner sc=new Scanner(System.in);	
		//Declare a int variable 
		System.out.print("Enter natural number: ");
		int number=sc.nextInt();
		if(number<=0)
		{
			System.out.println("Error: Please enter a natural number.");
			return;
		}	
		//Create two integer array
		int []evenSum=new int [number/2+1];
        int []oddSum=new int [number/2+1];
		int idxEven=0,idxOdd=0;
		for(int i=1;i<=number;i++)
		{
			if(i%2==0)
			{
				evenSum[idxEven]=i;
				idxEven++;
			}
			else
			{
				oddSum[idxOdd]=i;
				idxOdd++;
			}
		}
		System.out.print("Odd number are: ");
		for(int i=0;i<idxOdd;i++)
		{
			System.out.print(oddSum[i]+" ");
		}
		System.out.println();
		System.out.print("Even number are: ");
		for(int i=0;i<idxEven;i++)
		{
			System.out.print(evenSum[i]+" ");
		}
		
	    sc.close();
	}
}