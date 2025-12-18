import java.util.Scanner;
//Create a class name MultiplicationTable to indicating the purpose to find the table of given number. 
public class MultiplicationTable
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Declare a int variable number and take input from user.	   
		 System.out.print("Enter number between 6 to 9: ");
		 int number=sc.nextInt();
		 
		 
	   //Calculate and Display Table
	     for(int i=1;i<=10;i++)
		 {
		   System.out.println(number+" * "+i+" ="+number*i);
		 }
		 
		 sc.close();
	}
}