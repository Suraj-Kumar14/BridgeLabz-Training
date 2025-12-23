//Create a class name StringLength to indicating the purpose of find length without using length()
import java.util.Scanner;
public class StringLength
{
	public static void main(String [] args){
	//Create Scanner object
	Scanner sc=new Scanner(System.in);
	
	//Take String from user
	System.out.print("Enter String: ");
	String str=sc.next();
	
	//call method findLength
	int len1=findLength(str);
	
	//call method computeLength
	int len2=computeLength(str);
	
	if(len1==len2){
	System.out.println("Both are equal");
	}
	else {
	System.out.println("Both are not equal");
	}
	}
	
	//Method to find the length of String 
	public static int findLength(String str){
	int count=0;
	try{
		while(true){
		str.charAt(count++);
	  }
	}
	  catch(Exception e){
	  }
	  finally {
	    return count-1;
	  }
	}
	
	//Method to find length using built-in method
	public static int computeLength(String str){
	 return str.length();
	}
}
	