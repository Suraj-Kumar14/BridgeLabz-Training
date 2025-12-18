//Creating class with name CalculateProfitLoss to indicating the purpose is to calculate the profit, loss, and profit percentage.
public class CalculateProfitLoss
{
	public static void main(String [] args)
	{
		//Create two double variable costPrice, sellingPrice and assign value INR129 and INR191 respectively.
		double costPrice=129,sellingPrice=191;
		//create a int variable profit and a double variable profitPercentage.
		double profit;
		double profitPercentage;

		//Calculate profit and profitPercentage	
		profit=sellingPrice-costPrice;
		profitPercentage=profit/costPrice*100;

		//Display result
		System.out.println("The Cost Price is INR "+costPrice+" and Selling Price is INR "+sellingPrice+"\n"+"The Profit is INR "+profit+" and the profit percentage is "+profitPercentage);
	}
}