//Create a class name TrigonometricCalculator to calculate various trigonometric function
import java.util.Scanner;
public class TrigonometricCalculator
{
	//Create calculateTrigonometricFunctions method
	public static double[] calculateTrigonometricFunctions(double angle)
	{
		//convert angle to radian
		double radians=Math.toRadians(angle);
		//find sin,cos and tan using Math class
		double sin=Math.sin(radians);
		double cos=Math.cos(radians);
		double tan=Math.tan(radians);
		//return result
		return new double[]{sin,cos,tan};
	}
	
	//Create main method
	public static void main(String []args)
	{
		//Create a Scanner object
		Scanner sc=new Scanner(System.in);
		//Take angle
		System.out.print("Enter angle: ");
		double angle=sc.nextDouble();
		
		//call calculateTrigonometricFunctions method
		double [] result=calculateTrigonometricFunctions(angle);
		
		//Display result
		System.out.print("sin"+angle+" = "+result[0]+"\n");
		System.out.print("cos"+angle+" = "+result[1]+"\n");
		System.out.print("tan"+angle+" = "+result[2]);
		sc.close();
	}
}