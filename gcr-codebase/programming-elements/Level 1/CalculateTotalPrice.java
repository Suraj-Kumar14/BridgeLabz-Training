//Create class name CalculateTotalPrice to indicating the purpose of find total price.
import java.util.Scanner;
public class CalculateTotalPrice
{
	public static void main(String [] args)
	{
		//Create Scanner object for taking input.
		//Declare Variable unitPrice and quantity.
		  Scanner sc=new Scanner(System.in);
	          System.out.print("Enter Unit Price: ");
		  double unitPrice=sc.nextDouble();
		  System.out.print("Enter Quantity: ");
		  double quantity=sc.nextDouble();

		//Calculate Total price
		  double totalprice = unitPrice*quantity;

		//Display Total price
		System.out.print("The total purchase price is INR "+totalprice+" if the quantity "+quantity+" and unit price is INR "+unitPrice);
	}
}