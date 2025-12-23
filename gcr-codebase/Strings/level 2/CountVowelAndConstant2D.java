import java.util.Scanner;
//Create CountVowelAndConstant Class to compute the vowel and constant count if other Character then return not a letter
public class CountVowelAndConstant2D
{
	public static void main (String args[])
	{
		
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//Taking input as str from user
		System.out.println("Enter the string: ");
		String str = sc.nextLine();
		
		//calling function to countVandC
		String result[][] = countVandC(str);
		
		//displaying the ouput
        display(result);
	}
	public static String[][] countVandC(String str)
	{
		int len = str.length();
		String[][] data = new String[len][2];
		
		for(int i=0;i<len;i++){
			char c = str.charAt(i);
			
			String status = checkChar(c);
			data[i][0] = Character.toString(c);
			data[i][1] = status;
		}
		
		return data;
	}
	
	 // Method to check vowel, consonant, and not a letter
    public static String checkChar(char c) 
	{

        // Convert uppercase to lowercase using ASCII
        if (c >= 65 && c <= 90) {
            c = (char) (c + 32);
        }

        // Check if letter
        if (c >= 97 && c <= 122) {

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }
	public static void display(String result[][]){
		System.out.println("\nOutput:-");
		for(int i=0;i<result.length;i++){
			System.out.println("Character: "+ result[i][0] + "         Status: "+result[i][1]);
		}
	}
}	