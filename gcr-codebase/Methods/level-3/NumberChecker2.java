//Create a class NumberChecker2 to find the digit count,digit arrays, reverse arrays,arrays equal, Is palindrome and Duck number
import java.util.Arrays;
public class NumberChecker2 
{

    // Method to count digits in a number
    public static int countDigits(int number) 
	{
        if (number == 0) return 1;

        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    // Method to store digits of the number in an array
    public static int[] storeDigits(int number)
	{
        int count = countDigits(number);
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    // Method to reverse the digits array
    public static int[] reverseArray(int[] digits) 
	{
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    // Method to compare two arrays
    public static boolean compareArrays(int[] a, int[] b)
	{
        if (a.length != b.length) return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    // Method to check if a number is palindrome using digits
    public static boolean isPalindrome(int number) 
	{
        int[] digits = storeDigits(number);
        int[] reversed = reverseArray(digits);
        return compareArrays(digits, reversed);
    }

  
	public static boolean isDuckNumber(int number)
	{
		int[] digits = storeDigits(number);
		for (int i=0;i<digits.length;i++)
		{
			if(digits[i]==0) {
			return false;
		    }
		}	
		return true;
	}

    // Main method to test all utility methods
    public static void main(String[] args) 
	{
        int number = 12021;

        System.out.println("Number: " + number);

        int digitCount = countDigits(number);
        System.out.println("Digit Count: " + digitCount);

        int[] digits = storeDigits(number);
        System.out.println("Digits Array: " + Arrays.toString(digits));

        int[] reversedDigits = reverseArray(digits);
        System.out.println("Reversed Digits: " + Arrays.toString(reversedDigits));

        boolean arraysEqual = compareArrays(digits, reversedDigits);
        System.out.println("Arrays Equal: " + arraysEqual);

        boolean palindrome = isPalindrome(number);
        System.out.println("Is Palindrome: " + palindrome);

        boolean duckNumber = isDuckNumber(number);
        System.out.println("Is Duck Number: " + duckNumber);
    }
}
