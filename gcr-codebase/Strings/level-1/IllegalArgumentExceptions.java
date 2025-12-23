import java.util.*;
import java.io.*;
//Create IllegalArgumentExceptions Class to generate the illegal arguments exception
public class IllegalArgumentExceptions
{
	public static void main (String args[]){
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//Taking input as str from user
		System.out.println("Enter the string: ");
		String str = sc.next();
		
		//calling function handleException
		try{
			System.out.println("Trying to pass string arguments null : ");
			handleException(null);
		}catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		//calling function
		try{
			System.out.println("\n\nTrying to this string: "+str);
			handleException(str);
		}catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void handleException(String str){
		if(str==null){
			throw new IllegalArgumentException("string null not allowed. Please!");
		}else{
			System.out.println("string length : "+str.length());
		}
	}
}