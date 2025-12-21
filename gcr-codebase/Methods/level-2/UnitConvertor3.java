//Create a class name UnitConvertor3 to indicating the purpose of to convert unit.
import java.util.Scanner;
public class UnitConvertor3
{
	//Create a method to Fahrenheit to Celsius
	public static double convertFarhenheitToCelsius(double farhenheit) 
	{
		return (farhenheit-32)*5/9;
	}
	
	//Create a method to convert  Celsius to Fahrenheit 
	public static double convertCelsiusToFahrenheit(double celsius)
	{
		return (celsius * 9 / 5) + 32;
	}
	
	//Create a method to convert pounds to kilograms
	public static double convertPoundsToKilogram(double pounds)
	{
		return pounds*0.453592;
	}
	
	//Create a method to convert kilograms to pounds
	public static double convertKilogramToPounds(double kg)
	{
		return kg*2.20462;
	}
	
	//Create a method to convert gallons to liters 
	public static double convertGallomsToLiters(double gallons)
	{
		return gallons*3.78541;
	}
	
	//Create a method to convert liters to gallons 
	public static double convertLitersToGallons(double liters)
	{
		return liters*0.264172;
	}
	
	
	//Create main method 
	public static void main(String [] args)
	{
		//Create a Scanner object
		Scanner sc=new Scanner(System.in);
		//Take input in farhenheit,celsius,pounds,kg,gallons,and liters
		System.out.print("Enter Fahrenheit: ");
		double farhenheit=sc.nextDouble();
		System.out.print("Enter Celsius: ");
		double celsius=sc.nextDouble();
		System.out.print("Enter pounds: ");
		double pounds=sc.nextDouble();
		System.out.print("Enter Kilogram: ");
		double kg=sc.nextDouble();
		System.out.print("Enter gallons: ");
		double gallons=sc.nextDouble();
		System.out.print("Enter liters: ");
		double liters=sc.nextDouble();
		
		
		//Call method and display result
		System.out.print(farhenheit+" farhenheit = "+convertFarhenheitToCelsius(farhenheit)+" celsius");
		System.out.println();
		System.out.print(celsius+" celsius = "+convertCelsiusToFahrenheit(celsius)+" farhenheit");
		System.out.println();
		System.out.print(pounds+" pounds = "+convertPoundsToKilogram(pounds)+" kilograms");
		System.out.println();
		System.out.print(kg+" kilograms = "+convertKilogramToPounds(kg)+" pounds");
		System.out.println();
		System.out.print(gallons+" gallons = "+convertGallomsToLiters(gallons)+" liters");
		System.out.println();
		System.out.print(liters+" liters = "+convertLitersToGallons(liters)+" gallons");
		sc.close();
	}
}
		