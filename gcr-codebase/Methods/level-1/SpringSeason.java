//Create a class name SpringSeason the purpose is to check whether it is spring season or not
import java.util.Scanner;
public class SpringSeason
{
	//Create method to checkSeason
	public static boolean checkSeason(int month, int day)
	{
	  if((month==3 && day>=20)||(month==4)||(month==5)||(month==6 && day<=20)) return true;
	  else return false;
	}
	
	//Create main method
	public static void main(String []args)
	{
		//Declare two int variable month and day and take input from command line
		int month=Integer.parseInt(args[0]);
		int day=Integer.parseInt(args[1]);
		
		//Call method checkSeason
		boolean result=checkSeason(month,day);
		
		//Display result
		if(result==true)
		System.out.println("It is a Spring Season");
		else 
		System.out.println("It is not a Spring Season");
	}
}