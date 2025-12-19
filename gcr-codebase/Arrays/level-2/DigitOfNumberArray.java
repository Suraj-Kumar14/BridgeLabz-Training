import java.util.Scanner;
//Create a class name DigitOfNumberArray to indicating the purpose to find the number of digit and also find largest and second largest element. 
public class DigitOfNumberArray
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //create a int variable number and take input
		System.out.print("Enter number: ");
		int number=sc .nextInt();
		int maxDigit=10;
	    int []digit=new int[maxDigit];
		int index=0;
		int temp=number;
	    //Iterate loop until 0.
		while(temp!=0)
		{
			digit[index]=temp%10;
			temp/=10;
			index++;
			if(index==maxDigit){
			break;
			}
		}

		//Find largest and second largest
		int largest=-1;
		int secondLargest=-1;
		for(int i=0;i<index;i++)
		{
			if(digit[i]>largest)
			{
			   secondLargest=largest;
			   largest=digit[i];
			}
			else if(digit[i]>secondLargest && digit[i]!=largest)
			{
				secondLargest=digit[i];
			}
		}
		
		
		 //Display result
		System.out.println("Largest digit: " + largest);
        if (secondLargest != -1) {
            System.out.println("Second largest digit: " + secondLargest);
        } else {
            System.out.println("There is no second largest digit.");
        }
		 sc.close();
	}
}