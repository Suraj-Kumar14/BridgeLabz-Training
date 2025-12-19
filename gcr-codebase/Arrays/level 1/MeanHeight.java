import java.util.Scanner;
//Create a class name MeanHeight to indicating the purpose to find the mean height of players present in a football team.  
public class MeanHeight
{
	public static void main(String [] args)
	{	   
	    //Create a Scanner object for taking input from user
		Scanner sc=new Scanner(System.in);			
	    //Declare a double array of size 11
		double []heights =new double [11];
		for(int i=0;i<heights.length;i++)
	    {
		    System.out.print("Enter heights of player "+(i+1)+": ");
		     heights[i]=sc.nextDouble();
		}
		//Declare a double variable sum
		double sum=0;
		for(int i=0;i<heights.length;i++)
		{
		     sum+=heights[i];
		}
		double mean=sum/11;
		 
		//Display mean height
            System.out.println("The mean height of a team player: "+mean);    
				
	   sc.close();
	}
}