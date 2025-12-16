import java.util.Scanner;
class Powercalculation
{
    public static void main(String [] args)
    {
	Scanner kb= new Scanner(System.in);
        
	//Take Two number as input from user
	System.out.println("Enter 2 numbers: ");
	double num1=kb.nextDouble();
	double num2=kb.nextDouble();

	//Calculating power of a Number
	double power=Math.pow(num1,num2);

	//Displaying Output
	System.out.printf("Power Of Number is %.2f%n",power);
     }
}