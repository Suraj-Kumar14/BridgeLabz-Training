// Writing a program to calculate height, weight, BMI and status of number of persons
import java.util.*;
public class BMI_Using2DArray
{
	public static void main(String args[])
	{ 
		//Create a Scanner object
		Scanner sc = new Scanner(System.in);
		
		// Take input for number of persons
		System.out.print("Enter number of persons: ");
		int number = sc.nextInt();
		//Create multidimensional array and status array
		double[][] personData = new double[number][3];
		String[] weightStatus = new String[number];
				
		for(int i=0; i<number; i++) {
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
		//Calculate BMI and check weight status
		for(int i=0; i<number; i++) {
			personData[i][2] = personData[i][0] / ((personData[i][1]*.3048) *(personData[i][1]*.3048));
			
			if(personData[i][2] <= 18.4) weightStatus[i] = "Underweight";
			else if(personData[i][2]<= 24.9) weightStatus[i] = "Normal";
			else if(personData[i][2] <= 39.9) weightStatus[i] = "Overweight";
			else weightStatus[i] = "Obese";
		}
		System.out.println();
		//Display weight,height,BMI and weight status
		for(int i=0; i<number; i++) {
			System.out.println("The weight of the person " + (i+1) + " is " + personData[i][0]);
			System.out.println("The height of the person " + (i+1) + " is " + personData[i][1]);
			System.out.println("The BMI of the person " + (i+1) + " is " + personData[i][2]);
			System.out.println("The weight status of the person " + (i+1) + " is " + weightStatus[i] + "\n");
		}
		sc.close();
	}
}