import java.util.Scanner;
class Average
{
    public static void main(String [] args)
    {
	Scanner kb= new Scanner(System.in);
        
	//Take Three numbers as input from user
	System.out.println("Enter 3 numbers: ");
	double num1=kb.nextDouble();
	double num2=kb.nextDouble();
	double num3=kb.nextDouble();

	//Calculating Average of Three Numbers
	double avg=(num1+num2+num3)/3;

	//Displaying Output
	System.out.printf("Average Of Numbers is %.2f%n",avg);
     }
}