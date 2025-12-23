//Create a class name ReverseString to reverse a String
import java.util.Scanner;
public class ReverseString
{
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		//Take String from user
		System.out.print("Enter String: ");
		String str=sc.next();
		char[] reverse = new char[str.length()];
		//Reverse String logic
		for(int i=0;i<str.length();i++)
		{
			reverse[str.length()-1-i]=str.charAt(i);
		}
		 
		//Display reverse String
		
			System.out.print(reverse);
		
		sc.close();
	}
}