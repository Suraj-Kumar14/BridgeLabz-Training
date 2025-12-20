//Create a class name SimpleInterest to indicating the purpose of to Simple interest
import java.util.Scanner;
public class SimpleInterest
{
	public static void main(String []args)
	{
		//Create a Scanner object
		Scanner sc=new Scanner(System.in);
		//Take principal
		System.out.print("Enter principal: ");
		double principal=sc.nextDouble();
		//Take rate
		System.out.print("Enter rate: ");
		double rate=sc.nextDouble();
		//Take time
		System.out.print("Enter time: ");
		double time=sc.nextDouble();
		double result=countSimpleInterest(principal,rate,time);
		
		//Display Simple interest
		 System.out.println("The Simple Interest is "+result+" for Principal "+principal+","+" Rate of Interest "+rate+" and Time "+time);
	}
	public static double countSimpleInterest(double principal, double rate, double time){
	return (principal*rate*time)/100;
	}
}
		