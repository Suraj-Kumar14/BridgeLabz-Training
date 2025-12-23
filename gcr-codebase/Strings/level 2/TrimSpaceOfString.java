import java.util.Scanner;
public class TrimSpaceOfString 
{

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        // Input
        System.out.println("Enter the string: ");
        String str = sc.nextLine();

        // Find start and end index
        int[] index = findTrimIndex(str);

        // Create trimmed string using user-defined substring
        String userTrim = createSubstring(str, index[0], index[1]);

        // Built-in trim
        String builtInTrim = str.trim();

        // Compare both strings
        boolean isEqual = compareStrings(userTrim, builtInTrim);
		
		//Display ouput
        System.out.println("\nOriginal String : \"" + str + "\"");
        System.out.println("User Trimmed    : \"" + userTrim + "\"");
        System.out.println("Built-in Trim   : \"" + builtInTrim + "\"");

        if (isEqual) {
            System.out.println("Result: Both strings are equal");
        } else {
            System.out.println("Result: Strings are NOT equal");
        }
    }

    // Method to find start and end index without spaces
    public static int[] findTrimIndex(String str) {

        int start = 0;
        int end = str.length() - 1;

        // Trim leading spaces
        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }

        // Trim trailing spaces
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    // Method to create substring using charAt()
    public static String createSubstring(String str, int start, int end) {

        String newStr = "";

        for (int i = start; i <= end; i++) {
            newStr += str.charAt(i);
        }
        return newStr;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}