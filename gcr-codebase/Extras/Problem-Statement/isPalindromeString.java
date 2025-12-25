import java.util.*;
public class isPalindromeString{
	public static void main(String [] args){
		
		// Creating Scanner object to take input from user
		System.out.println("Enter the string: ");
		Scanner sc = new Scanner(System.in);
		
		//Taking input from user
		System.out.print("Enter String: ");
		String str = sc.nextLine();

		//calling input method to take input 
		isPalindrome(str);
	}
	public static void isPalindrome(String str){
		int start = 0, end = str.length()-1;
		boolean f1 = true; 
		
		while(start<end){
			char c1 = str.charAt(start);
			char c2 = str.charAt(end);
			
			if(c1!=c2){
				f1 = false;
				break;
			}
			start++;
			end--;
		}
		
		if(f1){
			System.out.println("Yes Palindrome");
		}else{
			System.out.println("Not Palindrome");
		}
	}
}