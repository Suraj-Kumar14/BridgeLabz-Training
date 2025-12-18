//Create class DoubleOpt to indicating the purpose of finding some given expression.
import java.util.Scanner;
public class DoubleOpt
{
	public static void main(String [] args)
	{
	   //Create a Scanner object for taking input from the user.
	    Scanner sc =new Scanner(System.in);
	   //Create three variable a, b, and c and assign to Double.
	    Double a,b,c;
		System.out.print("Enter Value a: ");
		a=sc.nextDouble();
		System.out.print("Enter Value b: ");
		b=sc.nextDouble();
		System.out.print("Enter Value c: ");
		c=sc.nextDouble();
		
		//Display operation output
		System.out.print("The results of Double Operations are "+( a + b *c)+", "+( a * b + c)+", "+(c + a / b)+","+" and "+(a % b + c));
		
		sc.close();
	}
}