import java.util.Scanner;
//Create a class name ReverseNumber to indicating the purpose to reverse the array element. 
public class ReverseNumber
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //create a variable number and take input
		System.out.print("Enter number: ");
		int number=sc.nextInt();
		int count=0;
		int temp=number;
		while(temp!=0)
		{	
		   count++;
		   temp/=10;
		}
		int []digit=new int[count];
	    //Iterate loop for store elements.
		for(int i=0;i<count;i++)
		{
			digit[count-i-1]=number%10;
			number/=10;
		}
		int []reverse=new int[count];
		for(int i=0;i<count;i++)
		{
			reverse[i]=digit[count-i-1];
		}
		
		
		 //Display reverse number
		System.out.print("The reverse number is: ");
		for(int i=0;i<count;i++){
         System.out.print(reverse[i]);
        }
		 sc.close();
	}
}