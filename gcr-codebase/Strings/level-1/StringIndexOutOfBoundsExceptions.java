import java.util.*;
import java.io.*;
//Create StringIndexOutOfBoundsExceptions Class to generate the illegal arguments exception
public class StringIndexOutOfBoundsExceptions
{
	public static void main (String args[])
	{
		
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//Taking input as str from user
		System.out.println("Enter the string: ");
		String str = sc.next();
		
		//calling function handleException
		handleBoundexception(str);
	}
	
	//Method to handle string index bound exception
	public static void handleBoundexception(String str){
		try{
			System.out.println("The length of string is : " + str.charAt(str.length()));
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("String index out of bound Happend:!");
		}
	}
}