//Creating a class with name DiscountAmount to indicating the purpose of to finding the discount amount and final discounted fee.
import java.util.Scanner;
public class DiscountAmount
{
	public static void main(String [] args)
	{
	     //Create a Scanner Object for taking input from the user.
	       Scanner kb = new Scanner(System.in);
	     //Create a Double type variable name fee and take input from the User.
	       System.out.print("Enter fee: ");
	       double fee = kb.nextDouble();
	     //Create a Double type Variable name discountPerCent and take input from the User.
	       System.out.print("Enter discount Percent: ");
	       double discountPercent = kb.nextDouble();


	     //Create a discount variable name discount and assign to Double.
	     //Compute the discount and assign it to the discount variable.
	       double discount = fee*discountPercent/100;
	     //Create a Double type variable name finalFee that have to pay by subtracting the discount from the fee.
	       double finalFee = fee-discount;

	     //Displaying final fee
	       System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+finalFee);
	        kb.close();
	}
}
	        