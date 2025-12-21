//Create a class name SumOfNaturalNumbers to indicating the purpose to find the sum of all natural number
import java.util.Scanner;
public class SumOfNaturalNumbers
{
	//Create a method name findSum to check the sum of all natural number
	public static int findSum(int number)
	{
		int sum=0;
		for(int i=1;i<=number;i++){
		sum+=i;
		}
		return sum;
	}
	//Create main method 
	public static void main(String []args)
	{
		//Create a Scanner object
		Scanner sc=new Scanner(System.in);
		//Declare a int variable
		System.out.print("Enter a natural number: ");
		int number=sc.nextInt();
		//call method findSum
		int result=findSum(number);
		
		//Display sum of all natural number
		System.out.println("The sum of first "+number+" natural numbers is: "+result);
		sc.close();
	}
}