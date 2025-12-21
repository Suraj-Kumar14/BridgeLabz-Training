//create a class DivideChocolate to indicating the purpose of to divide N number of chocolates among M children
import java.util.Scanner;
public class DivideChocolate
{
	//Create a method findRemainderAndQuotient
	public static int[] findRemainderAndQuotient(int number, int divisor)
	{
		//find remainder and quotient
		int remainder=-1,quotient=-1;
		remainder=number%divisor;
		quotient=number/divisor;		
		return new int[]{quotient,remainder};
	}
	
	//Create main method
	public static void main(String [] args)
	{
		//Create a Scanner object
		Scanner sc=new Scanner(System.in);
		//Take number of Chocolate
		System.out.print("Enter number of Chocolate: ");
		int n=sc.nextInt();
		//Take number of children
		System.out.print("Enter number of children: ");
		int m=sc.nextInt();
		
		//call method findRemainderAndQuotient
		int []result=findRemainderAndQuotient(n,m);
		
		//Display remainder and quotient 
		System.out.print("Number of chocolates each children get is: "+result[0]+"\n");
		System.out.print("Number of remaining chocolate is: "+result[1]);
		sc.close();
	}
}