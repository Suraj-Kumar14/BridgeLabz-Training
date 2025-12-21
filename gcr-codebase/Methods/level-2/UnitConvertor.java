//Create a class name UnitConvertor to indicating the purpose of to convert kilometer to miles.
import java.util.Scanner;
public class UnitConvertor
{
	//Create a method to convert km to miles
	public static double convertKmToMiles(double km)
	{
		return km*0.621371;
	}
	
	//Create a method to convert miles to km
	public static double convertMilesToKm(double miles)
	{
		return miles*1.60934;
	}
	
	//Create a method to convert meter to feet
	public static double convertMeterToFeet(double meter)
	{
		return meter*3.28084;
	}
	
	//Create a method to convert feet to meter
	public static double convertFeetToMeter(double feet)
	{
		return feet*0.3048;
	}
	
	
	//Create main method 
	public static void main(String [] args)
	{
		//Create a Scanner object
		Scanner sc=new Scanner(System.in);
		//Take input in km,miles,feet, and meter
		System.out.print("Enter kilometers: ");
		double km=sc.nextDouble();
		System.out.print("Enter Miles: ");
		double miles=sc.nextDouble();
		System.out.print("Enter Meter: ");
		double meter=sc.nextDouble();
		System.out.print("Enter Feet: ");
		double feet=sc.nextDouble();
		
		//Call method and display result
		System.out.print(km+" km in miles is: "+convertKmToMiles(km));
		System.out.println();
		System.out.print(miles+" miles in Kilometer is: "+convertMilesToKm(miles));
		System.out.println();
		System.out.print(meter+" meter in Feet is: "+convertMeterToFeet(meter));
		System.out.println();
		System.out.print(feet+" feet in Meter is: "+convertFeetToMeter(feet));
		
		sc.close();
	}
}
		