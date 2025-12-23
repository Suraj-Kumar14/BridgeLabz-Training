//Create a class name SplitTextIntoWord to indicating the purpose of to split text into word
import java.util.Scanner;
public class SplitTextIntoWord
{
	public static void main(String [] args){
		//Create Scanner object
		Scanner sc=new Scanner(System.in);
		
		//Take String from user
		System.out.print("Enter String: ");
		String str=sc.nextLine();
		
		//call method findLength
		int len=findLength(str);
		
		//call method to split the text into word
		String[] words1=splitText(str,len);
		String[] words2=str.split("\\s+");
		
		//method to call comparewords
		compareWords(words1,words2);
	
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
	
	//Method to split the text into word
	public static String[] splitText(String str,int len){
		int wordCount=0;
		for(int i=0;i<len;i++)
		{
			if(str.charAt(i)==' '){
			wordCount++;
			}
		}
		String word[]=new String[wordCount];
		String temp="";
		int index=0;
		for(int i=0;i<len;i++){
			if(str.charAt(i)!=' '){
			temp+=str.charAt(i);
			}else {
			word[index++]=temp;
			temp="";
			}
		}
		return word;
	}
	
	public static void compareWords(String str1[],String str2[]){
		int len=str1.length;
		for(int i=0;i<len;i++)
		{
			String word1=str1[i];
			String word2=str2[i];
			if(word1.equals(word2)){
			System.out.println(word1+" --equals-- "+word2);
			}else{
				System.out.println(word1+" --Not equals-- "+word2);
			}
		}
	}
				
}
	