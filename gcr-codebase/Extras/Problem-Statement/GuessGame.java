import java.util.*;
public class GuessGame{
	public static void main(String[] args){
		
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//Taking input from user 
		System.out.println("Enter the number between 1 to 100 :");
		int n = sc.nextInt();
		
		if(n>100||n<0){
			System.exit(0);
		}
		
		int computerNumber = computerGuess();
		
		//calling function
		possibleWin(n,computerNumber);
	}
	public static int computerGuess(){
		Random r = new Random();
		int guess = r.nextInt(99)+1;
		return guess;
	}
	public static void possibleWin(int userNumber, int computerNumber){
		if(userNumber==computerNumber){
			System.out.println("Computer wins your number is "+u+" and the number guess by computer is "+c);
			return;
		}
		System.out.println("You wins your number is "+u+" and the number guess by computer is "+c);		
	}
}