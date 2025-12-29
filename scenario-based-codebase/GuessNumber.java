import java.util.Scanner;
//Create a GuessNumber class to indicating the purpose of guessing the number asked from user
public class GuessNumber{
	public static void main(String []args){
	//Create a Scanner object
	Scanner sc=new Scanner(System.in);
	//Take number from user
	System.out.print("Enter the number between 0 and 100: ");
	int number=sc.nextInt();
	
	//Logic to guess number
	int attempt=0;
	int maximumChance=5;
	do{
		if(number<0 || number>100){
			System.out.println("Invalid number!, Please enter number between 0 and 100");
			break;
		}
		System.out.println("Enter your guess number: ");
		int guessNumber=sc.nextInt();
		attempt++;
		if(guessNumber==number){
		System.out.println("|-----------------------------------|");
		System.out.println("Congratulation!, You guess correctly.");
		System.out.println("|-----------------------------------|");
		break;
		}
		else if(guessNumber<number){
		System.out.println("Number is Too low!");
		}else if(guessNumber>number){
		System.out.println("Number is Too high!");
		}
	   }while(attempt<maximumChance);
	}
}