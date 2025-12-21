//Create a class name UnitConvertor2 to indicating the purpose of to convert unit.
import java.util.Scanner;
public class UnitConvertor2
{
	//Create a method to convert yard to feet
	public static double convertYardsToFeet(double yards)
	{
		return yards*3;
	}
	
	//Create a method to convert feet to yard
	public static double convertFeetToYards(double feet)
	{
		return feet*0.333333;
	}
	
	//Create a method to convert meters to inches
	public static double convertMeterToInches(double meter)
	{
		return meter*39.3701;
	}
	
	//Create a method to convert inches to meter
	public static double convertInchesToMeter(double inches)
	{
		return inches*0.0254;
	}
	
	//Create a method to convert inches to meter
	public static double convertInchesToCentimeters(double inches)
	{
		return inches*0.254;
	}
	
	//Create main method 
	public static void main(String [] args)
	{
		//Create a Scanner object
		Scanner sc=new Scanner(System.in);
		//Take input in km,miles,feet, and meter
		System.out.print("Enter Yards: ");
		double yards=sc.nextDouble();
		System.out.print("Enter Feet: ");
		double feet=sc.nextDouble();
		System.out.print("Enter Meter: ");
		double meter=sc.nextDouble();
		System.out.print("Enter inches: ");
		double inches=sc.nextDouble();
		
		//Call method and display result
		System.out.print(yards+" yards = "+convertYardsToFeet(yards)+" feet");
		System.out.println();
		System.out.print(feet+" feet = "+convertFeetToYards(feet)+" yards");
		System.out.println();
		System.out.print(meter+" meters = "+convertMeterToInches(meter)+" inches");
		System.out.println();
		System.out.print(inches+" inches = "+convertInchesToMeter(inches)+" meter");
		System.out.println();
		System.out.print(inches+" inches = "+convertInchesToCentimeters(inches)+" centimeters");
		sc.close();
	}
}
		