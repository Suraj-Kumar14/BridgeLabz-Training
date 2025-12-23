import java.util.Scanner;
// Create CheckPalindrome Class to check the string is palindrome or not
public class CheckPalindrome{

    public static void main(String args[]) {
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//Taking input from user 
		System.out.println("Enter the string : ");
		String str = sc.nextLine();
		
		//calling method findPalindromeOne
		boolean f1 = findPalindromeOne(str);
		
		//calling method findPalindromeTwo
		boolean f2 = findPalindromeTwo(str);
		
		//calling method findPalindromeThree
		boolean f3 = findPalindromeThree(str);
		
		
		//display output
		if(f1){
			System.out.println("First logic Palindrome Yes");
		}else{
			System.out.println("First logic Palindrome No");
		}
		if(f2){
			System.out.println("Second logic Palindrome Yes");
		}else{
			System.out.println("Second logic Palindrome No");
		}
		if(f3){
			System.out.println("Thrid logic Palindrome Yes");
		}else{
			System.out.println("Third logic Palindrome No");
		}
		
		if(f1 && f2 && f3){
			System.out.println("All logic work correct for palidrome");
		}
    }

    // Method to check the string is palidrome or not 
	public static boolean findPalindromeOne(String str){
		int start = 0, end = str.length()-1;
		
		while(start<=end){
			if(str.charAt(start)!=str.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	// Method to check the string is palidrome or not 
	public static boolean findPalindromeTwo(String s){
		if(s.length() == 0 || s.length() == 1) {
			return true;
		}
		if(s.charAt(0) == s.charAt(s.length()-1)) {
			return findPalindromeTwo(s.substring(1, s.length()-1));
		}
		return false;
	}
	
	// Method to check the string is palidrome or not 
	public static boolean findPalindromeThree(String str){
		char c[] = str.toCharArray();
		int start = 0, end = c.length-1;
		
		while(start<=end){
			if(c[start]!=c[end]){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
 