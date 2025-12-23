import java.util.*;
import java.io.*;
//Create ArrayIndexOutOfBoundsExceptions Class to generate the array index bound exception
public class ArrayIndexOutOfBoundsExceptions
{
	public static void main (String args[])
	{
		
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//decleare array
		int arr[] = new int[5];
		//Taking input as 5 number from user
		
		System.out.println("Enter the 5 number: ");
		for(int i=0;i<5;i++){
			arr[i] = sc.nextInt();
		}
		
		//calling function
		handleException(arr);
	}
	
	public static void generateException(int arr[])
	{
		System.out.println("If this method called then exception happend : " + arr[5]);
	}
	
	
	public static void handleException(int arr[])
	{
		try{
			System.out.println("No! exception happend to access index 5" + arr[5]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Yes! exception happend to access index 5");
		}catch(RuntimeException e){
			System.out.println("Genric exception happend: ");
		}
	}
}