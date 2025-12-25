import java.util.Scanner;
public class RemoveCharacterFromString 
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);

        // Take string input
        System.out.print("Enter a string: ");
        String originalString = sc.nextLine();

        // Take character to remove
        System.out.print("Enter character to remove: ");
        char characterToRemove = sc.next().charAt(0);

        // Create empty string to store result
        String modifiedString = "";

        // Loop through each character of the string
        for (int i = 0; i < originalString.length(); i++) {
            char currentChar = originalString.charAt(i);

            // Add character to result if it is not the one to remove
            if (currentChar != characterToRemove) {
                modifiedString += currentChar;
            }
        }

        // Print modified string
        System.out.println("Modified String: \"" + modifiedString + "\"");

        sc.close();
    }
}
