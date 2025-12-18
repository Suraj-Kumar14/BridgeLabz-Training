//Creating class with name HeightConvertor to indicating the purpose of converting centimeters into feet and inches.
import java.util.Scanner;
public class HeightConvertor
{
	public static void main(String [] args)
	{
		//Creating a Scanner object for taking input from the user
		  Scanner kb = new Scanner(System.in);
		//Create a variable height and assign to Double.
		//Take height input from user.
		  System.out.print("Enter your height in centimeters: ");
		  double height = kb.nextDouble();
		//Create Two variable feet and inches and assign to double.
		  double feet, inches;

		//Convert centimeters into feet and inches.
		  inches = height/2.54;
		  feet = inches/12;

		//Display Height in feet and inches.
		  System.out.println("Your Height in cm is "+height+" while in feet is "+feet+" and inches is "+inches);
		  kb.close();
	}
} 