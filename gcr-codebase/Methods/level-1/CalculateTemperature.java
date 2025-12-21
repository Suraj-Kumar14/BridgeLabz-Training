//Create a class name CalculateTemperature to indicating the purpose of to calculate the wind chill temperature.
import java.util.Scanner;
public class CalculateTemperature
{
	//Create method calculateWindChill
	public static double calculateWindChill(double temp, double windSpeed)
	{
		//Calculate windChill 
		double windChill=35.74+0.6215*temp+(0.4275*temp-35.75)*Math.pow(windSpeed,0.16);
		return windChill;
	}
	
	//Create main method
	public static void main(String [] args)
	{
		//Create a Scanner object
		Scanner sc =new Scanner(System.in);
		//Take temperature and windSpeed
		System.out.print("Enter Temperature: ");
		double temperature=sc.nextDouble();
		System.out.print("Enter Wind Speed: ");
		double windSpeed=sc.nextDouble();
		
		//Call method calculateWindChill
		double result=calculateWindChill(temperature,windSpeed);
		
		//Display wind cill temperature
		System.out.print("The Wind Chill temperature of given temperature and wind speed is: "+result);
		sc.close();
	}
}
	