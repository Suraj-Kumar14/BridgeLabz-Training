import java.util.*;
public class BasicCalculator{
	public static void main(String [] args){
		
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//Taking input from user 
		System.out.print("Enter Number1: ");
		int first = sc.nextInt();
		System.out.print("Enter Number2: ");
		int second = sc.nextInt();
		System.out.print("Enter Operator: ");
		char op = sc.next().charAt(0);
		
		System.out.println("The answer is "+cal(first,second,op));
	}
	//This function solve the calculator part
	public static double cal(int f, int s,char op){
		switch(op){
			case '+':
			    return f+s;
			case '-':
			   return f-s;
			case '*':
			    return f*s;
			case '/':
			    return f/s;
			default:
			   return 0;
		}
	}
}