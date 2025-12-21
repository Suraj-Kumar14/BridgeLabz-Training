import java.util.Scanner;
//Create a class name StudentVoteChecker to indicating the purpose to check whether the student can vote depending on his/her age. 
public class StudentVoteChecker
{
	//Create canStudentVote method
	public static boolean canStudentVote(int age)
	{ 
		//Check student can vote 
		if(age<0)
		{
			return false;
		}
	    if(age>=18)		
		{
			return true;
		}
		return false;
	}
	
	//Create main method 
	public static void main(String [] args)
	{
	    //Create a Scanner object for taking input from user
		Scanner sc=new Scanner(System.in);
		StudentVoteChecker checker=new StudentVoteChecker();
		
	    //Declare array to store age of 10 student
		int []age=new int [10];
		//Take input 
		for(int i=0;i<age.length ;i++)
		{
			System.out.print("Enter the age of "+(i+1)+" Student: ");
			age[i]=sc.nextInt();
			
			boolean canVote=checker.canStudentVote(age[i]);
		
	        //Display result
			if(canVote)
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