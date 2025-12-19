import java.util.Scanner;
//Create a class name MultipleValue to indicating the purpose to store multiple value until press 0 and negative number  
public class MultipleValue

{
	public static void main(String [] args)
	{
	   
	    //Create a Scanner object for taking input from user
		Scanner sc=new Scanner(System.in);
	   //Declare a array of size 10
		double []arr=new double[10];
		double total=0.0;
		//Store values 
		int i=0;
		System.out.println("You entered: ");
		while(true)
		{
			if(10<=i){
				break;
			}
		   double temp = sc.nextDouble();
		   if(temp==0 || temp<0)
		   {
		      break;
		   }
		   arr[i] = temp;
		   i++;		   
		}		
		//Get values and add the total values
		for(i=0;i<arr.length;i++)
		{
			total+=arr[i];    
		}
		
		//Display result
		System.out.println("The sum of given number is: "+total);
	   sc.close();
	}
}