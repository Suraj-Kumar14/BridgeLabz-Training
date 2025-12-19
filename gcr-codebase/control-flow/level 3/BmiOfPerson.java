import java.util.Scanner;
//Create a class name BmiOfPerson to indicating the purpose of to find the BMI and status of a person. 
public class BmiOfPerson
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Take Number as input.	   
		 System.out.print("Enter weight in kg: ");
		 double weight=sc.nextDouble();
		 System.out.print("Enter height in cm: ");
		 double height=sc.nextDouble();
	   
	   //Check BMI by formula BMI = weight / (height * height).
		 double bmi=weight/(height*height);
		 if(bmi<=18.4)
		 {
		    System.out.println(bmi+" - Underweight");
		 }
		 else if(bmi>=18.5 && bmi<=24.9)
		 {
		    System.out.println(bmi+" - Normal");
		 }
		 else if(bmi>=25.0 && bmi<=39.9)
		 {
		    System.out.println(bmi+" - Overweight");
		 }
		 else 
		 {
		    System.out.println(bmi+" - Obese");
		 }
		 
		 sc.close();
	}
}