import java.util.Scanner;
//Create a class name LeapYearUsingSingleIf to indicating the purpose of to determine whether the year is leap or or not a leap year. 
public class LeapYearUsingSingleIf
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Take year as input.	   
		 System.out.print("Enter year: ");
		 int year=sc.nextInt();
	   //Check entered year is after the year 1582.
	     if(year>=1582)
		{
		   if(year>=1582 && (year%4==0 && year%100!=0) || year%400==0)
		    {
			   System.out.println(year+" Is leap year");
			}  
			else
	    	{
		        System.out.println(year+" Is not leap year");
		    } 		 
		}	
	    else
		{
		   System.out.println("Please Enter the year after 1581");
		}  	   
		 sc.close();
	}
}