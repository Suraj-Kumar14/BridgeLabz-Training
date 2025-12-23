import java.util.Scanner;
//Create SplitTextAndFindMaxMin Class to split the word from string 
public class SplitTextAndFindMaxMin
{
	public static void main (String args[]){
		
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//Taking input as str from user
		System.out.println("Enter the string: ");
		String str = sc.nextLine();
		
		//calling function to compute the length without built-in-method
		int length = countLength(str);
		
		//calling method to extract the word in text 
		String[] words = extractWord(str,length);
		
		//calling function wordWithLength
		String result[][] = wordWithLength(words);
		
		//calling function wordMinMaxLength
		int minMax[] = wordMinMaxLength(result);
		
		//displaying the ouput
		System.out.println("Length of: ");
		System.out.println("\nMin \tMax");
		System.out.println("---------------");
			
		System.out.println(result[minMax[0]][0]+"\t"+result[minMax[1]][0]);
		
	}
	public static void compareWords(String str1[], String str2[]){
		int len = str1.length;
		
		for(int i=0;i<len;i++){
			String word1 = str1[i];
			String word2 = str2[i];
			if(word1.equals(word2)){
				System.out.println(word1+" --equals-- "+word2);
			}else{
				System.out.println(word1+" --Not equals-- "+word2);
			}
		}
	}
	
	public static String[] extractWord(String str, int len){
		int wordCount = 1;
		for(int i=0;i<len;i++){
			if(str.charAt(i)==' '){
				wordCount+=1;
			}
		}
		
		String word[] = new String[wordCount];
		String temp = "";
		int index = 0;
		for(int i=0;i<len;i++){
			if(str.charAt(i)!=' '){
				temp+=str.charAt(i);
			}else{
				word[index++] = temp;
				temp = "";
			}
		}
		word[index] = temp;
		
		return word;
	}
	public static int countLength(String str){
		int len = str.length();
		int count = 0;
		
		try{
			int i=0;
			while(true){
			str.charAt(count++);
				
			}
		}catch(Exception e){
			
		}finally{
			return count-1;
		}
	}
	//method to create 2D array (word + length)
	public static String[][] wordWithLength(String word[]){
		String[][] data = new String[word.length][2];
		
		for(int i=0;i<word.length;i++){
			data[i][0] = word[i];
			data[i][1] = String.valueOf(countLength(word[i]));
		}
		
		return data;
	}
	public static int[] wordMinMaxLength(String data[][]){
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		int idxMin = -1;
		int idxMax = -1;
		
		for(int i=0;i<data.length;i++){
			int len = Integer.parseInt(data[i][1]);
			if(len<min){
				min = len;
				idxMin = i;
			}
			if(len>max){
				max = len;
				idxMax = i;
			}
		}
		return new int[]{idxMin,idxMax};
	}
}