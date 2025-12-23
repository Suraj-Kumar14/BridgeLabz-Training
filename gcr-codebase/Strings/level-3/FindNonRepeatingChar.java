import java.util.Scanner;
// Create FindNonRepeatingChar Class to compute the unique Char
public class FindNonRepeatingChar
{

    public static void main(String args[]) {
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//Taking input from user 
		System.out.println("Enter the string : ");
		String str = sc.nextLine();
		
		//calling method findLength
		int freq[] = findNonRepeated(str);
		
		//display output
		display(freq);
    }

    // Method to calculate the length of string without using built-in-method
	public static int[] findNonRepeated(String str){
		int freq[] = new int[256];
		
		for(int i=0;i<str.length();i++){
			freq[str.charAt(i)]++;
		}
		return freq;
	}
	
	public static void display(int freq[]){
		System.out.println("Here is the non-repeating character: ");
		for(int i=0;i<freq.length;i++){
			if(freq[i]==1){
				System.out.println((char)i);
			}
		}
	}
}