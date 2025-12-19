import java.util.Scanner;
//Create a class name MultiplicationTable to indicating the purpose to give the table of number  
public class MultiplicationTable

{
	public static void main(String [] args)
	{
	   
	    //Create a Scanner object for taking input from user
		Scanner sc=new Scanner(System.in);
		//Declare int variable number and take input
		System.out.print("Enter number: ");
		int number=sc.nextInt();
	    //Declare a array of size 10
		int []arr=new int [10];
		//Store input of table 
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=number*(i+1);
		}
		System.out.println();
		
		//Display Result
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(number+" * "+ (i+1)+" = "+arr[i]);    
		}	
					
	   sc.close();
	}
}