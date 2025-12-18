//Create class IntOperation to indicating the purpose of finding some given expression.
import java.util.Scanner;
public class IntOperation
{
	public static void main(String [] args)
	{
	   //Create a Scanner object for taking input from the user.
	    Scanner sc =new Scanner(System.in);
	   //Create three variable a, b, and c and assign to int.
	    int a,b,c;
		System.out.print("Enter Value a: ");
		a=sc.nextInt();
		System.out.print("Enter Value b: ");
		b=sc.nextInt();
		System.out.print("Enter Value c: ");
		c=sc.nextInt();
		
		//Display operation output
		System.out.print("The results of Int Operations are "+( a + b *c)+","+( a * b + c)+","+(c + a / b)+","+" and "+(a % b + c));
		
		sc.close();
	}
}
		  