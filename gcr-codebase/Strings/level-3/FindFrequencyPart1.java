import java.util.Scanner;
// Create FindFrequencyPart1 Class to compute the frequency of character
public class FindFrequencyPart1{

    public static void main(String args[]) {
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//Taking input from user 
		System.out.println("Enter the string : ");
		String str = sc.nextLine();
		
		//calling method findLength
		String freq[][] = findNonRepeated(str);
		
		//display output
		display(freq);
    }

    // Method to calculate the length of string without using built-in-method
	public static String[][] findNonRepeated(String str){
		int freq[] = new int[256];
		
		for(int i=0;i<str.length();i++){
			freq[str.charAt(i)]++;
		}
		
		String[][] freqAndChar = new String[256][2];
		for(int i=0;i<freq.length;i++){
			char c = (char)i;
			int count = freq[i];
			
			freqAndChar[i][0] = String.valueOf(c);
			freqAndChar[i][1] = String.valueOf(count);
		}
		return freqAndChar;
	}
	
	public static void display(String freq[][]){
		System.out.println("Frequency character: ");
		System.out.println("----------------------");
		
		System.out.println("\n\nchar\tfrequency");
		for(int i=0;i<freq.length;i++){
			System.out.println(freq[i][0] + "\t" + freq[i][1]);
		}
	}
}