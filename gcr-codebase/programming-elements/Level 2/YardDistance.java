//Create a class with name YardDistance to indicating the purpose of  the find distance in yard and miles for the distance provided by user in feets.
import java.util.Scanner;
public class YardDistance
{
	public static void main(String [] args)
	{
		//Creating a Scanner object for taking input from the user.
		  Scanner sc =new Scanner(System.in);
		// Create a variable name distanceInFeet and assign to double.
		  System.out.println("Enter Distance in feets: ");
		  double distanceInFeet = sc.nextDouble(); 
		//Create three variable yard and miles.
		  double yard,miles;

		//Calculate yard and miles.
		  yard=distanceInFeet/3;
	          miles=yard/1760;

		//Display Yard and miles.
		  System.out.println("The distance in Yard is "+yard+"while the distance in miles is "+miles);
		sc.close();
	}
}