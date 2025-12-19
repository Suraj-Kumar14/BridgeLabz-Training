import java.util.Scanner;
//Create a class name YoungestTallestArray to indicating the purpose to find the youngest and tallest of three friend. 
public class YoungestTallestArray
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //create two int array and one variable 
		String[] friend={"Amar","Akbar","Anthony"};
	    int []age=new int[3];
	    double[] height= new double[3];
		for(int i=0;i<3;i++)
		{
			//Take age
			System.out.print("Enter age of "+friend[i]+": ");
			age[i]=sc.nextInt();
			//Take height
			System.out.print("Enter Height of "+friend[1]+": ");
			height[i]=sc.nextDouble();
		}

		//Find youngest and tallest
		int youngestIndex=0;
		int tallestIndex=0;
		 for(int i=0;i<3;i++)
		 {
		    //Find youngest
            if (age[i]<age[youngestIndex])
			{
				youngestIndex=i;
			}
            //Find tallest
		    if (age[i]<age[tallestIndex])
			{
				tallestIndex=i;
			}			
		 }
		 
		 //Display result
		System.out.println("Youngest friend: " + friend[youngestIndex] + " (Age: " + age[youngestIndex] + ")");
        System.out.println("Tallest friend: " + friend[tallestIndex] + " (Height: " + height[tallestIndex] + " cm)");
          
		 sc.close();
	}
}