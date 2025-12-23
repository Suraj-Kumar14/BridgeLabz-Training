import java.util.Scanner;
public class RemoveCharacter 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the string
        System.out.print("String: ");
        String input = scanner.nextLine();

        // Input the character to remove
        System.out.print("Character to Remove: ");
        char ch = scanner.next().charAt(0);

        StringBuilder result = new StringBuilder();

        // Loop through the string and remove the character
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ch) {
                result.append(input.charAt(i));
            }
        }

        System.out.println("Modified String: \"" + result + "\"");
        scanner.close();
    }
}
