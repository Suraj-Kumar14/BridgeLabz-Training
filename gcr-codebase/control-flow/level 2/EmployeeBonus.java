import java.util.Scanner;
//Create a class name EmployeeBonus to indicating the purpose of finding the employee bonus based on their year of service. 
public class EmployeeBonus
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Declare two Double variable as salary, bonus and one int variable year.
	   //Take input in salary and year from user.
	     System.out.print("Enter your Salary: ");
		 double salary=sc.nextDouble();
		 System.out.print("Enter year of service: ");
		 int year=sc.nextInt();
		 
		 
	   //Calculate and Display bonus
	     if(year>5)
		 {
		   double bonus=salary*5/100;
		   System.out.println("The bonus amount is "+bonus);
		 }	   
		 else
		 {
			   System.out.println("You are not eligible for bonus");
		 }
		 
		 sc.close();
	}
}