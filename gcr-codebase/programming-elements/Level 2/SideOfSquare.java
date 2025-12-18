//Creating a class with name SideOfSquare to indicating the purpose to find the side of square.
import java.util.Scanner;
public class SideOfSquare
{
	public static void main(String [] args)
	{
	  //Create Scanner object for taking input from the user.
	    Scanner sc = new Scanner(System.in);
	  //Create a double type variable perimeter and take perimeter from the user.
	    System.out.print("Enter Perimeter: ");
	    double perimeter = sc.nextDouble();
	  //Create a Variable name lengthOfSide and assign to double.
	    double lengthOfSide;

	  //Calculate Side of square.
	    lengthOfSide=4*perimeter;

	  //Display side of square.
	    System.out.println("The length of the side is "+lengthOfSide+" whose perimeter is "+perimeter);
		
		sc.close();
	}
}
	    	