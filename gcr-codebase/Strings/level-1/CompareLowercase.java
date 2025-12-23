import java.util.Scanner;
//Create CompareLowercase Class to convert the lower to lower and compare the two string
public class CompareLowercase{
	public static void main (String args[]){
		
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//Taking input as str from user
		System.out.println("Enter the string: ");
		String str = sc.nextLine();
		
		//converting string to uppercase
		String newStr1 = str.toLowerCase();
		
		//calling function compareCharacter
		String newStr2 = convertCharacter(str);
		
		//calling function to compare both string
		boolean result = compareCharacter(newStr1,newStr2);
		
		//displaying the ouput
		if(result){
			System.out.println("Both are equal");
		}else{
			System.out.println("Both are not equal");
		}
	}
	public static String convertCharacter(String str){
		int len = str.length();
		String newStr1 = "";
		for(int i=0;i<len;i++){
			char c = str.charAt(i);
			if((int)c>=65 && (int)c<92){
				newStr1+=(char)(c+32);
			}else{
				newStr1+=c;
			}
		}
		return newStr1;
	}
	
	public static boolean compareCharacter(String s1, String s2){
		int len1 = s1.length();
		int len2 = s2.length();
		
		for(int i=0;i<len1;i++){
			if(s1.charAt(i)!=s2.charAt(i)){
				return false;
			}
		}
		return true;
	}
}