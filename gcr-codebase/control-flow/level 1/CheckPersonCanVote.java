import java.util.Scanner;
//Create a class name CheckPersonCanVote to indicating the purpose of checking a person can vote or not.
public class CheckPersonCanVote
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
		 //Create a variable age and take input from user.
		 System.out.print("Enter age: ");
		 int age=sc.nextInt();
		 
		//Check whether it is eligible for vote or not. 
		 if(age>=18)
		 {
			System.out.println("The person's age is "+age+" and can vote");
		 }
		 else 
		 {
		    System.out.println("The person's age is "+age+" and cannot vote");
		 }
		  
		 sc.close();
	}
}