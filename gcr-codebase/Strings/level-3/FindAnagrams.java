import java.util.Scanner;
// Create FindAnagrams Class to compute the two string is anagram or not
public class FindAnagrams{

    public static void main(String args[]) {
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//Taking input from user 
		System.out.println("Enter the first string : ");
		String strFirst = sc.nextLine();
		
		System.out.println("Enter the second string : ");
		String strSecond = sc.nextLine();
		
		//calling method findLength
		boolean result = findAnagramsTwoStrings(strFirst, strSecond);
		
		//display output
		if(result){
			System.out.println("Both string are anagrams");
		}else{
			System.out.println("Both string are not anagrams");
		}
    }

    // Method to calculate the length of string without using built-in-method
	public static boolean findAnagramsTwoStrings(String str1, String str2){
		int freq1[] = new int[256];
		int freq2[] = new int[256];
		
		for(int i=0;i<str1.length();i++){
			freq1[str1.charAt(i)]++;
		}
		for(int i=0;i<str2.length();i++){
			freq2[str2.charAt(i)]++;
		}
		for(int i=0;i<256;i++){
			if(freq1[i]!=freq2[i]){
				return false;
			}
		}
		return true;
	}
}