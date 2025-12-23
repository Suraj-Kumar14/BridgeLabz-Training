import java.util.Scanner;
//Create PrintCharacter Class to compute the character from string and validate then print
public class PrintCharacters
{
	public static void main (String args[]){
		
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//Taking input as str from user
		System.out.println("Enter the string: ");
		String str = sc.next();
		
		//calling function findCharacter
		char ch1[] = findCharacter(str);
		
		//calling function computeCharacter2
		char ch2[] = computeCharacter2(str);
		
		//Displaying character
		System.out.println("String character: ");
		for(int i=0;i<ch2.length;i++){
			System.out.println(ch2[i]);
		}
		
		//calling function compareCharacter
		compareCharacter(ch1,ch2);
	}
	public static char[] findCharacter(String str){
		char ch1[] = new char[str.length()];
		for(int i=0;i<str.length();i++){
			ch1[i] = str.charAt(i);
		}
		return ch1;
	}
	
	public static char[] computeCharacter2(String str){
		return str.toCharArray();
	}
	
	public static void compareCharacter(char ch1[], char ch2[]){
		int len1 = ch1.length;
		int len2 = ch2.length;
		
		boolean f1 = true;
		if(len1!=len2){
			f1 = false;
		}else{
			for(int i=0;i<len1;i++){
				if(ch1[i]!=ch2[i]){
					f1 = false;
					break;
				}
			}
		}
		if(f1){
			System.out.println("Both String character equal!");
		}else{
			System.out.println("Both String character not equal!");
		}
	}
}