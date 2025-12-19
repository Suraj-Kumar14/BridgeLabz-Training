import java.util.Scanner;
//Create a class name ZaraBonusCalculation to indicating the purpose to calculate the bonus of employee. 
public class ZaraBonusCalculation
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
		 int employee=10;
	   //Create a double array
	    double []salary=new double[employee];
	    double []yearOfService=new double[employee];
		double []bonus=new double[employee];
		double []newSalary=new double[employee];
		double totalBonus=0;
		double totalOldSalary=0;
		double totalNewSalary=0;
		 
	   //take input from employee
	   for(int i=0;i<employee;i++)
	   {
		   System.out.println("Enter details for Employee " + (i + 1));
		   System.out.print("Enter  Salary: ");
		   salary[i]=sc.nextDouble();
		   
		   System.out.print("Enter year Of Service: ");
		   yearOfService[i]=sc.nextDouble();
		   
		   if(salary[i]<=0 || yearOfService[i]<0)
		   {
				System.out.println("Invalid input enter again: ");
				i--;
				continue;
			}
			System.out.println();
	    }	
	    
		//Calculate bonus and new salary
		for(int i=0;i<employee;i++)
		{
			if(yearOfService[i]>5)
			{
				bonus[i]=salary[i]*5/100;
			}
			else if (yearOfService[i]<5)
			{
				bonus[i]=salary[i]*2/100;
			}
			
            newSalary[i]=salary[i]+bonus[i];
			totalBonus+=bonus[i];
		    totalNewSalary+=newSalary[i];
			totalOldSalary+=salary[i];
		}
		
		//Display result
		 System.out.println("Total Old Salary: " + totalOldSalary);
		 System.out.println("Total Bonus: " + totalBonus);
		 System.out.println("Total new Salary: " + totalNewSalary);
		 
		 sc.close();
	}
}