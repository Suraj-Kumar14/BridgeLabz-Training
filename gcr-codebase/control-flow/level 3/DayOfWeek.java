import java.util.Scanner;
//Create a class name DayOfWeek to indicating the purpose to prints the day of the week . 
public class DayOfWeek
{
	public static void main(String [] args)
	{
	   
	   //Declare three variable and Take input using command line.	   
		 int m=Integer.parseInt(args[0]);
		 int d=Integer.parseInt(args[1]);
		 int y=Integer.parseInt(args[2]);
	   
	   //Prints the day of the week that the date falls on. 
		 int y0=y-(14-m)/12;
		 int x=y0+y0/4-y0/100+y0/400;
		 int m0=m+12*((14-m)/12)-2;
		 int d0=(d+x+(31*m0)/12)%7;
		 
	   //Display day of the week
		 System.out.println("The day of week is "+d0);
	}
}