//Create a class name SubstringOccurrences to count how many time given substring occur in string
import java.util.Scanner;
public class SubstringOccurrences
{
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		//Take String
		System.out.print("Enter String: ");
		String str=sc.nextLine();
		
		//Input the substring
		System.out.print("Enter Substring: ");
		String substring=sc.nextLine();
		
		int count=0;
		int index=0;
		while((index=str.indexOf(substring,index))!=-1)
		{	
			count++;
			index+=substring.length();
		}
		System.out.println("The substring \""+substring+"\" occurs "+count+" times.");
		sc.close();
	}
}