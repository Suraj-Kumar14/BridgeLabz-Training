import java.util.Scanner;
class SimpleInterest
{
    public static void main(String [] args)
    {
	Scanner kb =new Scanner(System.in);

	//Take Principal from user
        System.out.println("Enter Principal: ");
	int principal=kb.nextInt();

	// Take Rate from user 
	System.out.println("Enter Rate: ");
	double rate=kb.nextDouble();

	//Take Time From user
	System.out.println("Enter Time: ");
	double time=kb.nextDouble();

        // Calculating Simple Interest
	double SI=(principal*rate*time)/100;

	//Displaying output
	System.out.printf("Simple interest is %.2f%n",SI);
    }
}

	