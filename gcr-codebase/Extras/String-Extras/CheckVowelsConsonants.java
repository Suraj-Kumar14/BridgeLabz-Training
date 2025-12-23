//create a class name checkVowelsConsonants to check vowel and consonant in a string
import java.util.Scanner;
public class checkVowelsConsonants
{
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter String: ");
		String str=sc.next();
		
		int vowel=0,consonant=0;
		//looping for check vowel and consonant
		for (int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
			if(ch=='a' ||ch=='e'||ch=='i'|ch=='o'||ch=='u'||ch=='A' ||ch=='E'||ch=='I'|ch=='O'||ch=='U'){
				vowel++;
			}
			else{
			consonant++;
			}
		}
		System.out.println(vowel+" Vowel present in this string ");
		System.out.println(consonant+" consonant present in this string ");
		sc.close();
	}
}