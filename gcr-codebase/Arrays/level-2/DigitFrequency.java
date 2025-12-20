import java.util.Scanner;
//Create a class name DigitFrequency to indicating the purpose to find the frequency of digit. 
public class DigitFrequency
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //create a variable number and take input
		System.out.print("Enter number: ");
		long number=sc.nextLong();
		int count=0;
		long temp=number;
		//Count number of digit
		while(temp!=0)
		{	
		   count++;
		   temp/=10;
		}
		int []digit=new int[count];
	    //Save digit in array.
		for(int i=0;i<count;i++)
		{
			digit[count-i-1]=(int)number%10;
			number/=10;
		}
		//Find Frequency using array size 10
		long []frequency=new long[10];
		for(int i=0;i<digit.length;i++)
		{
			frequency[digit[i]]++;
		}
		
		
		 //Display frequency of each digit
		System.out.println("Digit Frequency: ");
		for(int i=0;i<10;i++){
		if(frequency[i]>0){
           System.out.println("Digit "+i+": "+frequency[i]);
          }
		}
		 sc.close();
	}
}