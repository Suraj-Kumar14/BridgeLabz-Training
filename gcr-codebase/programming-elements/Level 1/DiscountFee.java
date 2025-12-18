// Creating a class with name DiscountFee to indicating the purpose is to find the discount amount.
public class DiscountFee
{
	public static void main(String [] args)
	{
		//Create a int variable name fee and assign 125000 to it.
		  double fee=125000;
		//Create a int variable name discountPercentage and assign 10 to it.
		  double discountPercentage=10;


		//Create a Double variable discount.
		  double discount=125000*10/100;
		//Calculate fee by subtracting the discount from the fee.
		  fee = fee-discount;

		//Displaying fee the student will pay for the course.
		  System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+fee);
	}
}