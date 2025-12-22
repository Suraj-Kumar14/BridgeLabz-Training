//Create a class name QuadraticEquation to find quadratic expression
import java.util.Scanner;
public class QuadraticEquation
{
	//Method for find root
	public static double [] findRoot(double a,double b,double delta  )
	{
		if(delta==0){
		double root_of_x=-b/(2*a);
		return new double[]{root_of_x};
		}
		else if(delta>0){
		double root1_of_x1=(-b+Math.sqrt(delta)/(2*a));
		double root1_of_x2=(-b-Math.sqrt(delta)/(2*a));
		return new double[]{root1_of_x1,root1_of_x2};
		}
		else return new double[]{};
		
	}	
	public static void main (String [] args)
	{
		//Create a Scanner object
		Scanner sc=new Scanner(System.in);
		//Take input
		System.out.print("Enter A: ");
		double a=sc.nextDouble();
		System.out.print("Enter B: ");
		double b=sc.nextDouble();
		System.out.print("Enter C: ");
		double c=sc.nextDouble();
		
		//calculate delta
		double delta=Math.pow(b,2)+4*a*c;
		//call method findRoot
		double []result=findRoot(a,b,delta);
		
		//Display result
		if(result.length==1) System.out.print("The roots of equation is: "+result[0]);
		else if (result.length==0)System.out.print("No  roots!");
		else System.out.print("The roots of equation is: "+result[0]+" and "+result[1]);
		
		sc.close();
	}
}