//Creating a class with name ConvertDistance to indicating the purpose of convert distance in kilometers to miles.
import java.util.Scanner;
public class ConvertDistance
{
	public static void main(String [] args)
	{
	    //Create a variable km, miles and assign type as Double.
	      double km, miles;
	    //Create Scanner Object to taking input from the User.
	      Scanner kb = new Scanner(System.in);
	    //Take input in km using Scanner Object from User.
	      System.out.print("Enter kilometer: ");
	      km = kb.nextDouble();


	    //Convert Kilometers in miles.
	      miles=km*1.6;

	    //Displaying miles
	      System.out.println("The total miles is "+miles+" mile for the given "+km+"km");
	       kb.close();
	}
}
	