//create a class QuotientRemainder to indicating the purpose of find the quotient and remainder
import java.util.Scanner;
public class QuotientRemainder
{
	//Create a method findRemainderAndQuotient
	public static int[] findRemainderAndQuotient(int number, int divisor)
	{
		//find remainder and quotient
		int remainder=-1,quotient=-1;
		remainder=number%divisor;
		quotient=number/divisor;		
		return new int[]{remainder,quotient};
	}
	
	//Create main method
	public static void main(String [] args)
	{
		//Create a Scanner object
		Scanner sc=new Scanner(System.in);
		//Declare two variable and take input
		System.out.print("Enter number: ");
		int number=sc.nextInt();
		System.out.print("Enter divisor: ");
		int divisor=sc.nextInt();
		
		//call method findRemainderAndQuotient
		int []result=findRemainderAndQuotient(number,divisor);
		
		//Display remainder and quotient 
		System.out.print("Remainder is: "+result[0]+"\n");
		System.out.print("Quotient is: "+result[1]);
		sc.close();
	}
}