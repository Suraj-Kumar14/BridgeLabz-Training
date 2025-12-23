import java.util.Scanner;
// Create FindFrequencyPart2 Class to compute the frequency of character
public class FindFrequencyPart2{

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
		
		int size = 0;
		
		for(int i=0;i<freq.length;i++){
			if(freq[i]>=1){
				size+=1;
			}
		}
		
		String[][] freqAndChar = new String[size][2];
		int idx = 0;
		
		for(int i=0;i<freq.length;i++){
			char c = (char)i;
			int count = freq[i];
			
			if(count>=1){
				freqAndChar[idx][0] = String.valueOf(c);
				freqAndChar[idx][1] = String.valueOf(count);
				idx++;
			}
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
		
		System.out.println("\n\nUnique Character");
		for(int i=0;i<freq.length;i++){
			int count = Integer.parseInt(freq[i][1]);
			if(count==1){
				System.out.println(freq[i][0]);
			}
		}
	}
}
 