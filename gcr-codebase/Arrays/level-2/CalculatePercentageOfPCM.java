import java.util.Scanner;
//Create a class CalculatePercentageOfPCM to calculate the percentage of three marks
public class CalculatePercentageOfPCM
{
	public static void main(String []args)
	{
		//Create a Scanner object
		Scanner sc=new Scanner(System.in);
		//take input to number of students
		System.out.print("Enter number of student: ");
		int number=sc.nextInt();
		//Array to store marks of physics,chemistry, and maths
		int [][]marks=new int[number][3];
		double []percentage=new double[number];
		char []grade=new char[number];
		for(int i=0;i<number;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(j==0)
				{
					System.out.print("Enter Physics marks of "+(i+1)+" student: ");
					marks[i][j]=sc.nextInt();
					if(marks[i][j]<0)
					{
					  System.out.println("Enter positive number: ");
					   j--;
					   continue;
					}
				
				}
				else if(j==1)
				{
					System.out.print("Enter chemistry marks of "+(i+1)+" student: ");
					marks[i][j]=sc.nextInt();
					if(marks[i][j]<0)
					{
					  System.out.println("Enter positive number: ");
					   j--;
					   continue;
					}
				}
				else if(j==2)
				{
					System.out.print("Enter maths marks of "+(i+1)+" student: ");
					marks[i][j]=sc.nextInt();
					if(marks[i][j]<0)
					{
					  System.out.println("Enter positive number: ");
					   j--;
					   continue;
					}
				}
			}
			//Calculate percentage	
			percentage[i]=(marks[i][0]+marks[i][1]+marks[i][2])/3.0; 
			//Calculate Grade
			if(percentage[i]>=80){
				grade[i]='A';
			}
			else if(percentage[i]>=70&&percentage[i]<=79){
				grade[i]='B';
			}
			else if(percentage[i]>=60&&percentage[i]<=69){
				grade[i]='C';
			}
			else if(percentage[i]>=50&&percentage[i]<=59){
				grade[i]='D';
			}
			else if(percentage[i]>=40&&percentage[i]<=49){
				grade[i]='E';
			}
			else {
				grade[i]='R';
			}
		}
		System.out.println();
		//Display marks, percentage and grade of a student
		for(int i=0;i<number;i++){
			System.out.print("The Marks, Percentage, and Grade of "+(i+1)+" Student are:"+"\n");
			System.out.print("Marks: "+(marks[i][0]+marks[i][1]+marks[i][2])+"\n");
			System.out.print("Percentage: "+percentage[i]+"\n");
			System.out.print("Grade: "+grade[i]+"\n");
			System.out.println();
		}
		sc.close();
	}
}