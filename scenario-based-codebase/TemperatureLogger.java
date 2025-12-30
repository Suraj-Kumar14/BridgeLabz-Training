import java.util.Scanner;
//Create a class name TemperatureLogger to find the max and average temperature over 7 days
public class TemperatureLogger{
	public static void main(String [] args){
	
	//Create a Scanner object
	Scanner sc=new Scanner(System.in);
	//Array to store 7 days temperature
	double []temperature=new double[7];
	//Variable to store maximum temperature and its average
	double maxTemp=Integer.MIN_VALUE;
	double average;
	double totalTemp=0;
	
	//Loop for taking temperature from user
	for(int i=0;i<7;i++){
		System.out.print("Enter temperature of "+(i+1)+" day: ");
		temperature[i]=sc.nextDouble();
		if(maxTemp<temperature[i]){
		maxTemp=temperature[i];
		}
		totalTemp+=temperature[i];
	}
	//find average
	average=totalTemp/7.0;
	System.out.println("Average temperature: "+average);
	System.out.println("Maximum temperature: "+maxTemp);
	}
}
	
	