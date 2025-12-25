import java.util.*;
public class FactorialUsingRecursion{
	public static void main(String [] args){
		
		// Creating Scanner object to take input from user
		System.out.println("Enter the positive number: ");
		Scanner sc = new Scanner(System.in);
		
		//Taking input from user 
		int number = sc.nextInt();

		//calling input method to take input 
		int factorial = generateFactorial(number);
		
		
		//display
		System.out.println("Factorial of "+number + " is : "+factorial);
	}
	public static int generateFactorial(int n){
		if(n==1){
			return n;
		}
		
		return n*generateFactorial(n-1);
	}
}