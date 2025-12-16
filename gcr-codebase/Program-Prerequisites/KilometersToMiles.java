import java.util.Scanner;
class KilometersToMiles
{
    public static void main(String [] args)
    {
	Scanner kb= new Scanner(System.in);
        
	//Takes Distance in Kilometers from the user
	System.out.println("Enter Kilometers: ");
	double kilometers=kb.nextDouble();

	//Converting Kilometers to Miles
	double miles=kilometers*0.621371;

	//Displaying Output as Miles
	System.out.printf("%.2f%n miles",miles);
     }
}