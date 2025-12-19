import java.util.Scanner;
//Create a class name MarksOfThreeSubject to indicating the purpose of to Compute the percentage and then calculate the grade . 
public class MarksOfThreeSubject
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Take Marks of three subject as input.	   
		 System.out.print("Enter physics marks: ");
		 int physics=sc.nextInt();
		 System.out.print("Enter chemistry marks: ");
		 int chemistry=sc.nextInt();
		 System.out.print("Enter maths marks: ");
		 int maths=sc.nextInt();
		 
		 
		 
	   //Compute percentage of three marks.
	     double percentage= (physics+chemistry+maths)/3;
	     if(percentage>=80)
		 {
		   System.out.println(percentage+"%"+"  'A'"+"  Level 4, above agency-normalized standards");
		 }
		 else if(percentage>=70 && percentage<=79)
		 {
		   System.out.println(percentage+"%"+"  'B'"+"  Level 3, at agency-normalized standards");
		 }
		 else if(percentage>=60 && percentage<=69)
		 {
		   System.out.println(percentage+"%"+"  'C'"+"  Level 2, below but approaching agency-normalized standards");
		 }
		 else if(percentage>=50 && percentage<=59)
		 {
		   System.out.println(percentage+"%"+"  'D'"+"  Level 1, well below agency-normalized standards");
		 }
		 else if(percentage>=40 && percentage<=49)
		 {
		   System.out.println(percentage+"%"+"  'E'"+"  Level 1, too below agency-normalized standards");
		 }
	     else
		 {
		   System.out.println(percentage+"%"+"  'R'"+"  Remedial standards");
		 }  	   
		 sc.close();
	}
}