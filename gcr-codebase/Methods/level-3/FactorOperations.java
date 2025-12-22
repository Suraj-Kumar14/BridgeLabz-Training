//Create a class name FactorOperations to perform various operation
import java.util.Scanner;
public class FactorOperations 
{

    // Method to find factors of a number and return them as an array
    public static int[] findFactors(int num)
	{
        int count = 0;
        
        // First loop to count the number of factors
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }

        // Create an array of the exact size
        int[] factors = new int[count];
        int index = 0;

        // Second loop to store factors in the array
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    // Method to find the greatest factor using the factors array
    public static int greatestFactor(int[] factors)
	{
        return factors[factors.length - 1]; 
    }

    // Method to find the sum of the factors
    public static int sumOfFactors(int[] factors) 
	{
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    // Method to find the product of the factors
    public static long productOfFactors(int[] factors)
	{
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    // Method to find the product of the cube of the factors
    public static long productOfCubes(int[] factors) 
	{
        long product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }

    public static void main(String[] args) 
	{
		//Create a Scanner object
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Find factors
        int[] factors = findFactors(number);

        // Display factors
        System.out.print("Factors: ");
        for (int f : factors) {
            System.out.print(f + " ");
        }
        System.out.println();
        System.out.println("Greatest factor: " + greatestFactor(factors));
        System.out.println("Sum of factors: " + sumOfFactors(factors));
        System.out.println("Product of factors: " + productOfFactors(factors));
        System.out.println("Product of cubes of factors: " + productOfCubes(factors));

        sc.close();
    }
}
