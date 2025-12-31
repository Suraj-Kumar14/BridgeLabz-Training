//import Scanner class from util package
import java.util.Scanner;
//Create a class name FestivalLuckyDraw
public class FestivalLuckyDraw{
	public static void main(String[] args){
	//Create a Scanner object
	Scanner sc=new Scanner(System.in);
	System.out.println("--Welcome to Festival Lucky Draw--");
	char morevisitor='y';
	
	while(morevisitor=='y'|| morevisitor=='Y'){
		System.out.println();
		System.out.print("Please Enter a Draws: ");
		int number=sc.nextInt();
		if(number<=0){
		System.out.println("Invalid number! Please enter positive number.");
		continue;
		}
		//check winner
		if(number%3==0 && number%5==0){
		System.out.println();
		System.out.println("-------Congratulations!-------");
		System.out.println("You won a gift");
		System.out.println("------------------------------");
		}else{
		System.out.println("Better luck next time!");
		}
		//Ask for morevisitor
		System.out.print("Is there another visitor? (y/n): ");
		morevisitor=sc.next().charAt(0);
	}
	System.out.println("Diwali Lucky Draw close. Thank you!");
	sc.close();
	}
}