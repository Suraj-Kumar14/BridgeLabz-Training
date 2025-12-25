import java.util.*;
public class FindMaxNumber
{
	public static void main(String [] args){
		
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//calling input method to take input 
		input(sc);
	}
	//this method takes input 
	public static void input(Scanner sc){
		System.out.print("Enter Three number: ");
		//Taking input from user 
		int first = sc.nextInt();
		int second = sc.nextInt();
		int third = sc.nextInt();
		
		findMax(first,second,third);
	}
	//this method find the max then print
	public static void findMax(int firstNumber,int secondNumber, int thirdNumber){
		if(firstNumber>secondNumber&&firstNumber>thirdNumber){
			System.out.println("Maximum number is "+firstNumber);
			return;
		}
		if(secondNumber>firstNumber&&secondNumber>thirdNumber){
			System.out.println("Maximum number is "+secondNumber);
			return;
		}
			System.out.println("Maximum number is "+thirdNumber);
			return;
	}
}