//Create a class name CreateSubstring to indicating the purpose of to create substring and compare two string
import java.util.Scanner;
public class CreateSubstring
{
	//method for Substring using built-in method
	public static String builtInSubstring(String str,int start,int end)
	{
		return str.substring(start,end);
	}
	
	//method for Substring using charAt() method
	public static String findSubstring(String str,int start,int end)
	{
		String newSubstring="";
		for(int i=0;i<end;i++)
		{
			newSubstring=String.valueOf(str.charAt(i));
		}
		return newSubstring;
	}
	
	public static void main(String [] args)
	{
	Scanner sc=new Scanner(System.in);
	//Take String
	System.out.print("Enter String: ");
	String str=sc.next();
	//Take start and end index
	System.out.print("Enter start index: ");
	int start=sc.nextInt();
	System.out.print("Enter end index: ");
	int end=sc.nextInt();
	//call method builtInSubstring
	String str1=builtInSubstring(str,start,end);
	//call method findSubstring
	String str2=findSubstring(str,start,end);
	
	//calling function for compare string
	compareSubstring(str1,str2);
	sc.close();
	
	}
	
	public static void compareSubstring(String str1,String str2)
	{
		int len1=str1.length();
		int len2=str2.length();
		boolean f1=true;
		if(len1!=len2)
		{	
			f1=false;
		}
		else
		{
			for(int i=0;i<len1;i++)
			{
				if(str1.charAt(i)!=str2.charAt(i)){
				 f1=false;
				 break;
				}
			}	
		}
		if(f1)
		{
			System.out.println("Both Substring equal!");
		}
		else{
			System.out.println("Both Substring not equal!");
			}
	}
}