import java.util.Scanner;
//Create a class name FactorArray to indicating the purpose to find the factor of given number.
public class FactorArray
{
	public static void main (String [] args)
	{
		//Create a Scanner object
		Scanner sc =new Scanner(System.in);
		//Create a variable number and take input
		System.out.print("Enter number: ");
		int number =sc.nextInt();
		//Create int variable maxFactor and index
		int maxFactor=10;
		int index=0;
		//Create a array
		int [] factor=new int [maxFactor];
		for(int i=1;i<=number;i++)
		{
			if(number%i==0)
			{
				if(index==maxFactor)
				{
					//If array is full double its size
					maxFactor*=2;
					int []temp=new int[maxFactor];
					
					//copy old elements
					for(int j=0;j<index;j++)
					{
						temp[j]=factor[j];
					}
					factor=temp;
				}
				//store factor
				factor[index]=i;
				index++;
			}
		}
		
		
		//Display Factor 
		System.out.println("The factor of "+number+" are: ");
		for(int i=0;i<index;i++)
		{
			System.out.println(factor[i]+" ");
		}
		sc.close();
	}
}	
