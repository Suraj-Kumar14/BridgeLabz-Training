import java.util.Scanner;
class AddTwoNumber
{
   public static void main(String [] args)
   {
    	Scanner kb = new Scanner(System.in);

	System.out.println("Enter Number1: ");
	int num1=kb.nextInt();

	System.out.println("Enter Number2: ");
	int num2=kb.nextInt();

	int sum=num1+num2;
	
	System.out.println("Sum is: "+sum);
    }
}
	