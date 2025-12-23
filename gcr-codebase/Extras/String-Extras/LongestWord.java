//Create a class name LongestWord to find the longest word in String
import java.util.Scanner;
public class LongestWord
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter sentence: ");
		String str=sc.nextLine();
		
		String [] words=str.split("\\s+");
		String longestWords="";
		for(String word:words){
			if(word.length()>longestWords.length()){
			longestWords=word;
		    }
		}
		System.out.println("The longest word is: "+longestWords);
		sc.close();
	}
}
		