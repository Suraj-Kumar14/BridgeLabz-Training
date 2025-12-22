//Create a class name NumberChecker1 to find the count of digit, sum of digit, sum of square of digit, Harshad number, and frequency of number
import java.util.Scanner;
public class NumberChecker1
{
	//method to count of digits
	public static int countDigits(int number)
	{
		int count=0;
		while(number!=0){
			count++;
			number/=10;
		}
		return count;
	}
	
	
	//method to Store the digits of the number in a digits array
	public static int[] storeDigits(int number)
	{
		int temp=number;
		int count=countDigits(number);
		int []digits=new int [count];
		for(int i=count-1;i>=0;i--)
		{
			digits[i]=temp%10;
			temp/=10;
		}
		return digits;
	}
	
	
	//method for sum of digits
	public static int findSum(int number)
	{
		int []digits=storeDigits(number);
		int sum=0;
		for(int d:digits){
			sum+=d;
		}
		return sum;
	}
	
	////method for sum of square of digits
	public static int findSumOfSquare(int number)
	{
		int []digits=storeDigits(number);
		int sumOfSquare=0;
		for(int d:digits){
			sumOfSquare+=Math.pow(d,2);
		}
		return sumOfSquare;
	}
	
	// Method to check if number is Harshad
    public static boolean isHarshad(int number) {
        int sum = findSum(number);
        return number % sum == 0;
    }
	
	
	//method to find frequency of a number
	 public static int[][] digitFrequency(int number) 
	 {
        int []digits=storeDigits(number);
        int[][] freq = new int[10][2]; // 0-9 digits

        for (int i = 0; i < 10; i++) {
            freq[i][0] = i; // digit
            freq[i][1] = 0; // frequency
        }

        for (int d : digits) {
            freq[d][1]++;
        }

        return freq;
    }


				
	public static void main(String[] args)
	{
		//Create a Scanner object
		Scanner sc=new Scanner(System.in);
		//Take number
		System.out.print("Enter number: ");
		int number=sc.nextInt();
		
		//call method countDigits
		System.out.print("The count of digit is: "+countDigits(number));
		System.out.println();
		//call method storeDigits
		int []digits=storeDigits(number);
		 System.out.print("Number is: ");
		for(int i=0;i<digits.length;i++)
		{
		    System.out.print(+digits[i]);
		}		
		System.out.println();
		System.out.println("Sum of digits: " + findSum(number));
        System.out.println("Sum of squares of digits: " + findSumOfSquare(number));
        System.out.println("Is Harshad number? " + isHarshad(number));
		 System.out.println("Digit Frequencies:");
        int[][] freq = digitFrequency(number);
        for (int i = 0; i < freq.length; i++) {
            if (freq[i][1] > 0) {
                System.out.println("Digit " + freq[i][0] + " occurs " + freq[i][1] + " times");
            }
        }

		
		sc.close();
	}
}
		