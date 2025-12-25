import java.util.*;
public class PrimeChecker{
	public static void main(String [] args){
		
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//Taking input from user 
		System.out.print("Enter number: ");
		int number = sc.nextInt();

		//calling input method to take input 
		isPrime(number);
	}
	public static void isPrime(int number){
		boolean f1 = true;
		
		if(number<=1){
			f1 = false;
		}		
		if(number%2==0){
			f1 = false;
		}
		
		for(int i=2;i*i<number;i++){
			if(number%i==0){
				f1 = false;
				break;
			}
		}
		if(f1){
			System.out.println("Number "+number + " is prime number!");
		}else{
			System.out.println("Number "+number + " is not prime number!");
		}
	}
}