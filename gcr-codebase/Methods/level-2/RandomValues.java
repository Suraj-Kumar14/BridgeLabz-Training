//Create a class name RandomValues to indicating the purpose of generates five 4 digit random values and then finds their average value, and their minimum and maximum value
import java.util.Scanner;
public class RandomValues
{
	public static int[] generate4DigitRandomArray(int size)
	{
		int []arr=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i] = (int)(Math.random() * 9000) + 1000;
		}
		return arr;
	}
	
	public static double[] findAverageMinMax(int[] numbers) 
	{
		int sum=0;
		int minValue=numbers[0];
		int maxValue=numbers[0];
		for(int i=0;i<numbers.length;i++)
		{
			sum+=numbers[i];
			if(numbers[i]<minValue)
			  minValue=numbers[i];
			if(numbers[i]>maxValue)
			  maxValue=numbers[i];
		}
		return new double[]{sum,minValue,maxValue};
	}


	public static void main(String [] args)
	{
		//Create Scanner object
		Scanner sc = new Scanner(System.in);
		//Take size
		System.out.print("Enter size of random number: ");
		int size=sc.nextInt();
		int []randomValue=generate4DigitRandomArray(size);
		double []result=findAverageMinMax(randomValue);
		
		//Display result
		for(int i=0;i<size;i++)
		{
			System.out.print("Random values of "+(i+1)+" is "+randomValue[i]+"\n");
		}
		System.out.print("Sum of Random values is "+result[0]+"\n");
		System.out.print("Min values is "+result[1]+"\n");
		System.out.print("Max values is "+result[2]);
		sc.close();
	}
}
		