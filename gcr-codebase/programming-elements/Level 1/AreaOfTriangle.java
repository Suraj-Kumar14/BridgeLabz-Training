//Creating a class with name AreaOfTrianle to find area of triangle in square inches and square centimeters.
import java.util.Scanner;
public class AreaOfTriangle
{
	public static void main(String [] args)
	{
	  //Create a Scanner object for taking input from the user.
	    Scanner kb = new Scanner(System.in);
	  //Declare two double type variable name base,height and take base and height from User.
	    System.out.print("Enter base: ");
	    double base=kb.nextDouble();
	    System.out.print("Enter height: ");
	    double height=kb.nextDouble();
	    

	  //Declare variable area as Double and find its value.
	    double areaInSqInches = 0.5*base*height;
	    double areaInSqCm = areaInSqInches * 6.4516;


	  //Display area of triangle
	    System.out.println("The area of triangle in square inches and square centimeters is"+areaInSqInches+" and "+areaInSqCm);

	  kb.close();
	}
}
