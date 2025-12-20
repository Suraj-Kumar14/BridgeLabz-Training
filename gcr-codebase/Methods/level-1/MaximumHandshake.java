//Create a class name maximumHandshake to indicating the purpose of to check the number of maximum handshake
import java.util.Scanner;
public class MaximumHandshake
{
	public static void main(String []args)
	{
		//Create a Scanner object
		Scanner sc=new Scanner(System.in);
		//Take number of student
		System.out.print("Enter number of students: ");
		int numberOfStudents=sc.nextInt();	
		//Call handshake method
		int result=handshake(numberOfStudents);
		
		//Display Maximum possible Handshake
		 System.out.println("The number of possible handshake "+result);
	}	
	public static int handshake(int numberOfStudents){
	return (numberOfStudents *(numberOfStudents-1))/2;
	}
}
		