import java.util.Scanner;
//Create a class name CalculatorUsingSwitch to indicating the purpose of to develop a calculator. 
public class CalculatorUsingSwitch
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Declare variable and Take input from user.	   
		 System.out.print("Enter first number: ");
		 double first=sc.nextDouble();
		 System.out.print("Enter second number: ");
		 double second=sc.nextDouble();
	   //Declare String variable op and take input.
		 System.out.print("Enter Operator: ");
		 String op = sc.next();
		 
	   
	   //Caculator 
		 switch(op)
		 {	  
		      case "+" :
		     {
				System.out.println("Addition of number is "+(first+second));
				break;
			 }
			  case "-" :
		     {
				System.out.println("Subtraction of number is "+(first-second));
				break;
			 }
			  case "*" :
		     {
				System.out.println("Multiplication of number is "+(first*second));
				break;
			 }
			  case "/" :
		     {
				System.out.println("Division of number is "+(first/second));
				break;
			 }
			  default :
		     {
				System.out.println("Invalid Operator");
				break;
			 }
		 }	 
		 
		 sc.close();
	}
}