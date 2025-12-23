import java.util.Scanner;
public class LexicographicalOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input two strings
        System.out.print("String 1: ");
        String str1 = scanner.nextLine();

        System.out.print("String 2: ");
        String str2 = scanner.nextLine();

        // Compare the strings
        int comparison = compareStrings(str1, str2);

        if (comparison < 0) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order");
        } else if (comparison > 0) {
            System.out.println("\"" + str1 + "\" comes after \"" + str2 + "\" in lexicographical order");
        } else {
            System.out.println("Both strings are equal in lexicographical order");
        }

        scanner.close();
    }

    // Method to compare two strings lexicographically
    public static int compareStrings(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int minLen = Math.min(len1, len2);

        // Compare characters one by one
        for (int i = 0; i < minLen; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 != c2) {
                return c1 - c2; 
            }
        }
        return len1 - len2;
    }
}
