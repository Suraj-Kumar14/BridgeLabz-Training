//Create a class name RemoveDuplicate to remove the duplicate character
import java.util.Scanner;
public class RemoveDuplicate 
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        String str = sc.nextLine();

        String result = "";

        // Remove duplicates
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            boolean isDuplicate = false;

            // Check characters before current index
            for (int j = 0; j < i; j++) {  // <-- use j < i
                if (current == str.charAt(j)) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                result += current;
            }
        }

        System.out.println("After removing duplicates: " + result);
        sc.close();
    }
}
