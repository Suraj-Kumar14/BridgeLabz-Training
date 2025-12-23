import java.util.Scanner;
import java.io.*;
// Create CalculateUniqueCharacter Class to compute unique character in string
public class CalculateUniqueCharacter 
{
    public static void main(String args[]) 
	{
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//Taking input from user 
		System.out.println("Enter the string : ");
		String str = sc.nextLine().toLowerCase();
		
		//calling method findLength
		int len = findLength(str);
		
		//calling find the findUniqueChar
		char result[] = str.toCharArray();
		int uniqueChar[] = findUniqueChar(str,len,result);
		
		//Display output
		display(uniqueChar, result);
    }

    // Method to calculate the length of string without using built-in-method
	public static int findLength(String str){
		int count = 0;
	
		try{
			while(true){
				str.charAt(count++);
			}
		}
		catch(Exception e){
			
		}
		finally{
			return count-1;
		}
	}	
	
	public static int[] findUniqueChar(String str, int len, char result[]){
		
		int index[] = new int[result.length];
		
		for(int i=0;i<result.length;i++){
			char c = result[i];
			if(index[i]==-1){
				continue;
			}
			for(int j=i+1;j<result.length;j++){
				if(c==result[j]){
					index[j] = -1;
				}
			}
		}
		return index;
	}
	
	public static void display(int index[], char result[]){
		System.out.println("Unique Character: ");
		for(int i=0;i<index.length;i++){
			if(index[i]!=-1){
				System.out.println(result[i]);
			}
		}
	}
}