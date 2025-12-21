//create a class SmallestLargest to indicating the purpose of find the smallest and largest number of three number
import java.util.Scanner;
public class SmallestLargest
{
	//Create a method findSmallestAndLargest
	public static int[] findSmallestAndLargest(int number1,int number2,int number3)
	{
		int smallest=number1, largest=number1;
		//find smallest
		if(number2<smallest)
			smallest=number2;
		if(number3<smallest)
			smallest=number3;
			
		//find largest
		if(number2>largest)
			largest=number2;
		if(number3>largest)
			largest=number3;
		
		return new int[]{smallest,largest};
	}
	//Create main method
	public static void main(String [] args)
	{
		//Create a Scanner object
		Scanner sc=new Scanner(System.in);
		//Declare three variable and take input
		System.out.print("Enter three number: ");
		int number1=sc.nextInt();
		int number2=sc.nextInt();
		int number3=sc.nextInt();
		
		//call method findSmallestAndLargest
		int []result=findSmallestAndLargest(number1,number2,number3);
		
		//Display smallest and largest 
		System.out.print("Smallest number is: "+result[0]+"\n");
		System.out.print("Largest number is: "+result[1]);
		sc.close();
	}
}