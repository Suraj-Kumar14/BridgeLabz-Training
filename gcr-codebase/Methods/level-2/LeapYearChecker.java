//Create a class name LeapYearChecker to indicating the purpose of to check whether the year is leap year or not using method
import java.util.Scanner;
public class LeapYearChecker
{
	//Create a method checkLeapYear 
	public static boolean checkLeapYear(int year)
	{
		if((year%4==0 && year%100!=0)||(year%400==0)){
		 return true;
		}
		else {
		return false;
		}
	}

	//Create main method
	public static void main(String [] args)
	{
		//Create a Scanner object
		Scanner sc=new Scanner(System.in);
		//Take year as input
		System.out.print("Enter Year: ");
		int year=sc.nextInt();
		
		//check year 
		if(year<1582)
		{
			System.out.print("Please enter year after 1581!");
		}
		else
		{
			//call method checkLeapYear
			if(checkLeapYear(year)==true){
			  System.out.println(year +" is leap year");
			}
			else {
			  System.out.println(year+" is not leap year");
			}
		}
		sc.close();
	}
}