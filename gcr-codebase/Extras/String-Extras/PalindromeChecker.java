//Create a class name PalindromeChecker to check palindrome
import java.util.Scanner;
public class PalindromeChecker
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		//Take String
		System.out.print("Enter String: ");
		String str=sc.next();
		char [] rev=new char[str.length()];
		
		//Reverse String
		for(int i=0;i<str.length();i++)
		{
			rev[str.length()-1-i]=str.charAt(i);
		}
		String reverse=new String(rev);
		if(str.equals(reverse)){
		System.out.println("String is palindrome!");
		}
		else
		System.out.println("String is not palindrome");
	}
}