//Writing a program to calculate height, weight, BMI and status of number of persons
import java.util.Scanner;
public class BMICalculator
{
	public static void main(String args[])
	{ 
		//Create a Scanner object
		Scanner sc = new Scanner(System.in);
		
		//Create multidimensional array and status array
		double[][] personData = new double[10][3];
				
		for(int i=0; i<10; i++) {
			//Take weight of a person
			do {
				System.out.print("Enter Weight of "+(i+1)+" person in kg: ");
				personData[i][0]=sc.nextDouble();
				if(personData[i][0]<=0){
				System.out.println("Invalid weight! Weight must be positive.");
			    } 
			}while(personData[i][0]<=0);
				
			//Take height of a person
		    do {
				System.out.print("Enter Height of "+(i+1)+" person in feet: ");
				personData[i][1]=sc.nextDouble();
				if(personData[i][1]<=0){
				System.out.println("Invalid weight! Weight must be positive.");
			    } 
			}while(personData[i][1]<=0);
			System.out.println();
		}
		String [] weightStatus=new String[10];
		for(int i=0; i<10; i++) {
			personData[i][2] = findBMI(personData[i][0],personData[i][1]);
			weightStatus[i]=findweightStatus(personData[i][2]);			
		}
		System.out.println();
		//Display weight,height,BMI and weight status
		for(int i=0; i<10; i++) {
			System.out.println("The weight of the person " + (i+1) + " is " + personData[i][0]);
			System.out.println("The height of the person " + (i+1) + " is " + personData[i][1]);
			System.out.println("The BMI of the person " + (i+1) + " is " + personData[i][2]);
			System.out.println("The weight status of the person " + (i+1) + " is " + weightStatus[i] + "\n");
		}
		sc.close();
	}
	//Method for calculate BMI
	public static double findBMI(double height,double weight)
	{
		return weight/((height*.3048)*(height*.3048));
	}
	
	//Method for find weight status
	public static String findweightStatus(double bmi)
	{
		
		if(bmi <= 18.4) return "Underweight";
		else if(bmi<= 24.9) return "Normal";
		else if(bmi <= 39.9) return "Overweight";
		else return "Obese";
	}
}