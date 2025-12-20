import java.util.Scanner;
//Create a class name BodyMassIndex to indicating the purpose of to find the BMI and status of a person. 
public class BodyMassIndex
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //Take Number as input.	   
		 System.out.print("Enter number of a person: ");
		 int number=sc.nextInt();
		 //Create array for weight and height
		 double []weight=new double[number];
		 double [] height=new double[number];
		 
	   //take weight and height
	     for(int i=0;i<number;i++)
		 {
			System.out.print("Enter weight of "+(i+1)+" person: ");
			weight[i]=sc.nextDouble();
			System.out.print("Enter height of "+(i+1)+" person: ");
			height[i]=sc.nextDouble();
		 }	
	   //create two array
	    double []bmi=new double[number];
		String []status={"Underweight", "Normal","Overweight","Obese"};
		//Check BMI by formula BMI = weight / (height * height) and print weight,height,BMI, and Status.
		for(int i=0;i<number;i++)
		{
			System.out.println("The Weight, Height, BMI, And Status of "+(i+1)+" Person: ");
			System.out.print("Weight="+weight[i]+"   ");
			System.out.print("Height="+height[i]+"   ");
		    bmi[i]=weight[i]/((height[i]*.3048)*(height[i]*.3048));			
			if(bmi[i]<=18.4)
			{
				System.out.println("  BMI= "+bmi[i]+"  Status= "+ status[0]);
			}
			else if(bmi[i]>=18.5 && bmi[i]<=24.9)
			{
				System.out.println("  BMI= "+bmi[i]+"  Status= "+ status[1]);
			}
			else if(bmi[i]>=25.0 && bmi[i]<=39.9)
			{
                System.out.println("  BMI= "+bmi[i]+"  Status= "+ status[2]);
			}
			else 
			{
				System.out.println(" BMI= "+bmi[i]+"  Status= "+ status[3]);
			}
			System.out.println();
		}
		 sc.close();
	}
}