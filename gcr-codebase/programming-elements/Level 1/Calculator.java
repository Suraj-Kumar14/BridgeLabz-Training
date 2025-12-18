//Creating a class with name Calculator to indicating the purpose of that can perform addition, subtraction, multiplication, and division.
import java.util.Scanner;
public class Calculator
{
	public static void main(String [] args)
	{
	  //Create Scanner object for taking input from the user.
	    Scanner kb = new Scanner(System.in);
	  //Declare four variable addition, subtraction, multiplication, division and assign to Double.
	    double addition, subtraction, multiplication, division;
	  //Declare two Double type variable name number1 and number2. 
	  //Take number1 and number2 input from the user.
            System.out.print("Enter First number: ");
	    double number1 = kb.nextDouble();
	    System.out.print("Enter Second number: ");
 	    double number2 = kb.nextDouble();

	   //Calculate addition, subtraction, multiplication, division.
	     addition = number1 + number2;
	     subtraction = number1 - number2;
	     multiplication = number1 * number2;
	     division = number1 / number2;

	   //Display addition, subtraction, multiplication, division.
	     System.out.printf("The addition, subtraction, multiplication and division value of 2 numbers %.2f and %.2f" +" is" +" %.2f"+","+" %.2f"+","+ " %.2f"+","+" and"+" %.2f",number1, number2,addition, subtraction, multiplication, division);

        kb.close();
	}
}
	  	     