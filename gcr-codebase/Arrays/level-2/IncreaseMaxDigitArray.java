import java.util.Scanner;
//Create a class name IncreaseMaxDigitArray to indicating the purpose to increase the size, find the number of digit and also find largest and second largest element. 
public class IncreaseMaxDigitArray
{
	public static void main(String [] args)
	{
	   //Create Scanner object for taking input from the user.
	     Scanner sc =new Scanner(System.in);
	   //create a variable number and take input
		System.out.print("Enter number: ");
		int number=sc.nextInt();
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
			if(index==maxDigit)
			{
				//increase size by 10
			    maxDigit+=10;
				//Create a new temp array
			    int [] temps=new int[maxDigit];
				for(int j=0;j<index;j++)
				{
					temps[j]=digit[j];
				}
				digit=temps;
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