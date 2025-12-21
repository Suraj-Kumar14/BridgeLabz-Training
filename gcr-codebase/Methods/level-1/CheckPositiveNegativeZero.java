//Create a class name CheckPositiveNegativeZero to indicating the purpose of to check positive negative or zero with the help of method
import java.util.Scanner;
public class CheckPositiveNegativeZero
{
	public static int checkNumber(int a){
	   if(a>0) return 1;
	   else if (a<0) return -1;
	   else return 0;
	}
	public static void main(String [] args)
	{
		//Create a Scanner object
		Scanner sc =new Scanner(System.in);
		//create a int variable number and take input
		System.out.print("Enter number: ");
		int number=sc.nextInt();
		//call method 
		int result=checkNumber(number);
		
		//Display result
		if(result==1)
		  System.out.print("Number is Positive");
	     else if(result==-1)
		  System.out.print("Number is Negative");
		else
		  System.out.print("Number is Zero");
		sc.close();
	}
}