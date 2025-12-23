import java.util.*;
import java.io.*;
//Create NullPointerException Class to generate the null pointer exception
public class NullPointerExceptions
{
	public static void main (String args[]){
		//calling function handleException
		handleException();
	}
	
	//Method to generate NullPointerException
	public static void generateException(){
		String text = null;
		System.out.println("Exception occurs! ");
	}
	
	public static void handleException(){
		String str = null;
		try{
			System.out.println("The length of string is : " + str.length());
		}catch(NullPointerException e){
			System.out.println("NullPointerException Happend:!");
		}
	}
}