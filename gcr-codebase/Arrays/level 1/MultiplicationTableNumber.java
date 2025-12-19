import java.util.Scanner;
//Create a class name MultiplicationTableNumber to indicating the purpose to give the table of number from 6 To 9.  
public class MultiplicationTableNumber
{
	public static void main(String [] args)
	{
	   
	    //Create a Scanner object for taking input from user
		Scanner sc=new Scanner(System.in);
		//Declare int variable number and take input
		System.out.print("Enter any number from 6 to 9: ");
		int number=sc.nextInt();
	    //Declare a array of size 10
		int []multiplicationResult=new int [10];
		//Calculate multiplication table 
		if(number>=6 & number<=9)
	    {		
		    for(int i=0;i<multiplicationResult.length;i++)
		    {
			   multiplicationResult[i]=number*(i+1);
		    }
		    System.out.println();
		
		   //Display Result
	    	for(int i=0;i<multiplicationResult.length;i++)
		   {
		     	System.out.println(number+" * "+ (i+1)+" = "+multiplicationResult[i]);    
		   }
		}
		else
		{
			System.out.println("Please enter a valid no: ");
		}			
	   sc.close();
	}
}