import java.util.Scanner;
//Create a class name CheckStudentCanVote to indicating the purpose to check whether the student can vote depending on his/her age. 
public class CheckStudentCanVote
{
	public static void main(String [] args)
	{
	   
	    //Create a Scanner object for taking input from user
		Scanner sc=new Scanner(System.in);
	    //Declare a array of size 10
		int []age=new int [10];
		//Take input 
		for(int i=0;i<age.length ;i++)
		{
			System.out.print("Enter the age of "+(i+1)+" Student: ");
			age[i]=sc.nextInt();
		}
		System.out.println();
		
		//Check student can vote and display it
		for(int i=0;i<age.length;i++)
		{
			if(age[i]<0)
			{
				System.out.println("Invalid age!");
			}
		    else if(age[i]>=18)
			{
				System.out.println("The student with the age "+age[i]+" can vote.");
			}
			else
			{
				System.out.println("The student with the age "+age[i]+" cannot vote.");
			}
		}
	   sc.close();
	}
}