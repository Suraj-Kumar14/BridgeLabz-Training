//Create a class name MaximumHandshake to indicating the purpose of finding the maximum number of handshake among N number of student.
import java.util.Scanner;
public class MaximumHandshake
{
	public static void main(String [] args)
	{
		//Create a Scanner object for taking input from the user.
		  Scanner sc=new Scanner(System.in);
		//Create a variable name numberOfStudents and assign as int.
		  System.out.print("Enter number of student: ");
		  int numberOfStudents=sc.nextInt(); 
		 

		//Calculate the maximum number of possible handshake.
		  int maximumNumberOfHandshake=(numberOfStudents*(numberOfStudents-1))/2;

		//Display possible handshake.
		  System.out.println("The Number of Posssible Handshake is: "+maximumNumberOfHandshake);
	}
}

