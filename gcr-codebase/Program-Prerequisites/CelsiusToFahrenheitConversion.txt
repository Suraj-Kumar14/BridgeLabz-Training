import java.util.Scanner;
class CelsiusToFahrenheitConversion
{
   public static void main(String [] args)
   {
	Scanner kb=new Scanner(System.in);
        System.out.println("Enter Celsius: ");
	double cel=kb.nextDouble();
	
	double fahren=(cel*9/5)+32;
	System.out.printf("Fahrenheit is " + fahren);
   }
}