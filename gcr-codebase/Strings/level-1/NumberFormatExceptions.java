import java.util.*;
import java.io.*;
//Create NumberFormatExceptions Class to generate the number format exception
public class NumberFormatExceptions
{
	public static void main (String args[]){
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//Taking input as str from user
		System.out.println("Enter the string with number: ");
		String str = sc.next();
		
		//calling function
		handleException(str);
	}
	
	public static void generateException(String str){
		int number = Integer.parseInt(str);
		System.out.println("Convert string to number : " + number);
	}
	
	
	public static void handleException(String str){
		try{
			int number = Integer.parseInt(str);
			System.out.println("String has number. No exception happend");
		}catch(NumberFormatException e){
			System.out.println("String has no number! Yes exception happend");
		}catch(RuntimeException e){
			System.out.println("Genric exception happend: ");
		}
	}
}