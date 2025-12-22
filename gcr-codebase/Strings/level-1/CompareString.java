//Create a class name CompareString to indicating the purpose of to compare to String using charAt() and equals
import java.util.Scanner;
public class CompareString
{		
	public static void main(String [] args)
	{
		//Create Scanner object
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter 1st String: ");
		String s1=sc.next();
		System.out.print("Enter 2nd String: ");
		String s2=sc.next();
		
		//compare string using charAt
		boolean f1=true;
		if(s1.length() != s2.length()){
			f1= false;
		}
		else
		{
			for(int i=0;i<s1.length();i++)
			{
				if(s1.charAt(i)!=s1.charAt(i))
				{
					f1= false;
					break;
				}
			}
		}
		
		//Compare String Using .equals
		boolean f2=s1.equals(s2);
		System.out.println(f1);
		System.out.println(f2);
		if(f1==true && f2==true){
			System.out.println("Str1 " + s1+ " And Str2 "+ s2 +" are equals!");
		}else
		{
			System.out.println("Str1 " + s1+ " And Str2 "+ s2 +" are not equals!");
		}
	}
}
		
		