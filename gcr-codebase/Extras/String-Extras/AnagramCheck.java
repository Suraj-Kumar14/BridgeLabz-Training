import java.util.Arrays;
import java.util.Scanner;
public class AnagramCheck 
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);

        // Take first string input
        System.out.print("Enter first string: ");
        String firstString = sc.nextLine();

        // Take second string input
        System.out.print("Enter second string: ");
        String secondString = sc.nextLine();

        // Remove spaces and convert to lowercase
        firstString = firstString.replaceAll("\\s", "").toLowerCase();
        secondString = secondString.replaceAll("\\s", "").toLowerCase();

        // Check length first
        if (firstString.length() != secondString.length()) {
            System.out.println("The strings are NOT anagrams.");
        } else {

            // Convert strings to character arrays
            char[] firstArray = firstString.toCharArray();
            char[] secondArray = secondString.toCharArray();

            // Sort both arrays
            Arrays.sort(firstArray);
            Arrays.sort(secondArray);

            // Compare sorted arrays
            if (Arrays.equals(firstArray, secondArray)) {
                System.out.println("The strings ARE anagrams.");
            } else {
                System.out.println("The strings are NOT anagrams.");
            }
        }
        sc.close();
    }
}
