//Create a class name TriangularPark to indicating the purpose of to find The round a athletes run
import java.util.Scanner;
public class TriangularPark
{
	public static void main(String []args)
	{
		//Create a Scanner object
		Scanner sc=new Scanner(System.in);
		//Take three side 
		System.out.print("Enter side1: ");
		double side1=sc.nextDouble();	
		System.out.print("Enter side2: ");
		double side2=sc.nextDouble();	
		System.out.print("Enter side3: ");
		double side3=sc.nextDouble();
		double totalDistance=5000.0;
		//Call calculateRound method
		double rounds=calculateRound(side1,side2,side3,totalDistance);
		
		//Display total round 
		 System.out.printf("The athlete need to complete "+rounds+" rounds to run 5km.");
	}	
	//Create Method calculateRound
	public static double calculateRound(double a,double b,double c,double totalDistance){
	  double perimeter=(a+b+c);
	  double result=totalDistance / perimeter;
	  return result;
	}
}
		