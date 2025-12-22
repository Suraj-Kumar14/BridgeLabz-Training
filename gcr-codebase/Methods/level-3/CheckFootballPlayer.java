import java.util.Scanner;
//Create a class name CheckFootballPlayer to indicating the purpose to find the shortest,tallest and mean height of players present in a football team.
import java.util.Random;  
public class CheckFootballPlayer
{
	public static void main(String [] args)
	{	   		
	    //Declare a double array of size 11
		double []heights =new double [11];
		Random random = new Random();
		for(int i=0;i<heights.length;i++)
	    {
		     heights[i]=random.nextDouble(101)+150;
			 System.out.print("Heights of "+(i+1)+" player is: "+heights[i]+"\n");
		}
		
		 System.out.println();
		//Display mean height
		System.out.println("The sum of all the elements of a team player: "+findSum(heights));    
		System.out.println("The mean height of a team player: "+findMean(findSum(heights)));    
		System.out.println("The shortest height of the players: "+findShortest(heights));    
        System.out.println("The  tallest height of the players : "+findTallest(heights));    
				
	}
	
	//Create method findSum
	public static double findSum(double []heights)
	{
		double sum=0;
		for(int i=0;i<heights.length;i++)
		{
		     sum+=heights[i];
		}
		return sum;
	}
	
	//method to find mean height
	public static double findMean(double sum)
	{
		double mean;
		return mean=sum/11;
	}
	
	//method to find shortest height
	public static double findShortest(double[]heights)
	{
		double shortest=heights[0];
		for(int i=0;i<heights.length;i++)
		{
			if(heights[i]<shortest){
				shortest=heights[i];
			}
		}
		return shortest;
	}
	
	//method to find tallest height
	public static double findTallest(double[] heights)
	{
		double tallest=heights[0];
		for(int i=0;i<heights.length;i++)
		{
			if(heights[i]>tallest){
				tallest=heights[i];
			}
		}
		return tallest;
	}
}