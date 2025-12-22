public class NumberChecker3
{

    // Method to check if a number is Prime
    public static boolean isPrime(int number)
	{
        if (number <= 1) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) 
		{
            if (number % i == 0)
                return false;
        }
        return true;
    }

    // Method to check if a number is Neon
    // Neon number: sum of digits of square == number
    public static boolean isNeon(int number)
	{
        int square = number * number;
        int sum = 0;

        while (square > 0)
		{
            sum += square % 10;
            square /= 10;
        }
        return sum == number;
    }

    // Method to check if a number is Spy
    // Spy number: sum of digits == product of digits
    public static boolean isSpy(int number) 
	{
        int sum = 0;
        int product = 1;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }

    // Method to check if a number is Automorphic
    // Automorphic number: square ends with the number
    public static boolean isAutomorphic(int number) 
	{
        int square = number * number;
        int temp = number;

        while (temp > 0) {
            if (temp % 10 != square % 10)
                return false;
            temp /= 10;
            square /= 10;
        }
        return true;
    }

    // Method to check if a number is Buzz
    // Buzz number: divisible by 7 OR ends with 7
    public static boolean isBuzz(int number)
	{
        return (number % 7 == 0) || (number % 10 == 7);
    }

    // Main method to test all utility methods
    public static void main(String[] args)
	{
        int number = 7;

        System.out.println("Number: " + number);

        System.out.println("Is Prime: " + isPrime(number));
        System.out.println("Is Neon: " + isNeon(number));
        System.out.println("Is Spy: " + isSpy(number));
        System.out.println("Is Automorphic: " + isAutomorphic(number));
        System.out.println("Is Buzz: " + isBuzz(number));
    }
}
