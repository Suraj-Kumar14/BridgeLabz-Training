import java.util.*;
public class GenerateFibonacciSequence{
	public static void main(String [] args){
		
		// Creating Scanner object to take input from user
		System.out.println("Enter the positive number: ");
		Scanner sc = new Scanner(System.in);
		
		//Taking input from user 
		System.out.print("Enter Number: ");
		int number = sc.nextInt();

		//calling input method to take input 
		generateSequence(number);
	}
	public static void generateSequence(int number){
		int pre = 0;
		int next = 1;
		if(number<0){
			System.out.println("Please Enter the positive number");
			return;
		}
		if(number==1){
			System.out.print(pre);
		}if(number>=2){
			System.out.print(pre+" ");
			System.out.print(next);
		}
		for(int i=2;i<number;i++){
			int curr = pre+next;
			System.out.print(" "+curr);
			pre = next;
			next = curr;
		}
	}
}