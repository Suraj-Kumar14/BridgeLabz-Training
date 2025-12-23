import java.util.Scanner;
public class MostFrequentCharacter 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("String: ");
        String input = scanner.nextLine();

        int maxCount = 0;
        char mostFrequent = ' ';

        // Convert string to character array
        char[] chars = input.toCharArray();

        // Count frequency of each character
        for (int i = 0; i < chars.length; i++) {
            int count = 1;

            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    count++;
                }
            }

            // Update most frequent character
            if (count > maxCount) {
                maxCount = count;
                mostFrequent = chars[i];
            }
        }

        System.out.println("Most Frequent Character: '" + mostFrequent + "'");
        scanner.close();
    }
}
