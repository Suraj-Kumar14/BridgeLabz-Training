import java.util.Scanner;
//Create CountVowelAndConstant Class to compute the vowel and constant count
public class CountVowelAndConstant
{
	public static void main (String args[])
	{
		
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//Taking input as str from user
		System.out.println("Enter the string: ");
		String str = sc.nextLine();
		
		//calling function to countVandC
		int result[] = countVandC(str);
		
		//displaying the ouput
		System.out.println("The length of vowel is : "+ result[0]);
		System.out.println("The length of constant is : "+ result[1]);
	}
	public static int[] countVandC(String str){
		int len = str.length();
		int countV = 0;
		int countC = 0;
		for(int i=0;i<len;i++){
			char c = str.charAt(i);
			
			String result = checkChar(c);
			
			if(result.equals("Vowel")){
				countV+=1;
			}else if(result.equals("Consonant")){
				countC+=1;
			}
		}
		
		return new int[]{countV,countC};
	}
	
	 // Method to check vowel, consonant, and not a letter
    public static String checkChar(char c) {

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
}	