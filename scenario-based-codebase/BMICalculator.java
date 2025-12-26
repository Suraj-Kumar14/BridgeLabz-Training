Create a class name BMICalculator to indicating the purpose of to find BMI
import java.util.Scanner;
public class BMICalculator 
{
    public static void main(String[] args) 
	{

        // Create Scanner object to take input from user
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter height in meters
        System.out.print("Enter height in meters: ");
        double heightInMeters = scanner.nextDouble();

        // Ask user to enter weight in kilograms
        System.out.print("Enter weight in kilograms: ");
        double weightInKg = scanner.nextDouble();

        // Calculate BMI using formula
        double bmi = weightInKg / (heightInMeters * heightInMeters);

        // Display BMI value
        System.out.println("\nYour BMI is: " + bmi);

        // Determine BMI category using if-else conditions
        if (bmi < 18.5) {
            System.out.println("BMI Category: Underweight");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("BMI Category: Normal");
        } else {
            System.out.println("BMI Category: Overweight");
        }

        // Close the scanner
        scanner.close();
    }
}
