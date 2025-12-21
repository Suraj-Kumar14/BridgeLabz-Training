import java.util.Scanner;
//Create a class name YoungestTallestComparison to indicating the purpose to find the youngest and tallest of three friend. 
public class YoungestTallestComparison
{
	//Create method findYoungest
	public static String findYoungest(int[]age, String[] names)
	{
		int minAge=age[0];
		int index=0;
		for(int i=1;i<age.length;i++)
		{
			if(age[i]<minAge)
			{
				minAge=age[i];
				index=i;
			}
		}
		return names[index];
	}
	
	//Create method findTallest	
	public static String findTallest(double[] height,String[] names)
	{
		double maxHeight=height[0];
		int index=0;
		for(int i=1;i<height.length;i++)
		{
			if(height[i]>maxHeight)
			{
				maxHeight=height[i];
				index=i;
			}
		}
		return names[index];
	}	
	
	
	//Create main method
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //create two int array and one variable 
		String[] names={"Amar","Akbar","Anthony"};
	    int []age=new int[3];
	    double[] height= new double[3];
		for(int i=0;i<3;i++)
		{
			//Take age
			System.out.print("Enter age of "+names[i]+": ");
			age[i]=sc.nextInt();
			//Take height
			System.out.print("Enter Height of "+names[i]+": ");
			height[i]=sc.nextDouble();
		}
		
		//find youngest and tallest
		String youngest=findYoungest(age,names);
		String tallest=findTallest(height,names);
		
		 //Display result
		System.out.println();
		System.out.println("Youngest friend: "+youngest);
        System.out.println("Tallest friend: " +tallest);
          
		 sc.close();
	}
}