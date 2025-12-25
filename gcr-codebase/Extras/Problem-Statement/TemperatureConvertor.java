import java.util.*;
public class TemperatureConvertor{
	public static void main(String[] args){
		
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//Taking input from user 
		System.out.print("Enter Temperature: ");
		double temp = sc.nextDouble();
		
		System.out.println("The clecius to fahrenheit "+fahrenheitToCelsius(temp));
		System.out.println("The fahrenheit to celsius "+celsiusToFahrenheit(temp));
	}
	//This function solve fahrenheit To Celsius
	public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }
	//This function solve celsius To Fahrenheit
    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }
}