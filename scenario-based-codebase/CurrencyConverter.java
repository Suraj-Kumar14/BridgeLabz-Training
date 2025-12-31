import java.util.Scanner;
public class CurrencyConverter{
	public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	char choice;
	do
	{
		System.out.print("Enter amount in INR: ");
		double amount=sc.nextDouble();
		System.out.println();
		System.out.println("----Choose target currency----");
		System.out.println("1.USD");
		System.out.println("2.EUR");
		System.out.println("3.JPY");
		System.out.println("4.CNY");
		System.out.println("5.GBP");
		
		System.out.print("Enter option(1-4): ");
		int currency=sc.nextInt();
		System.out.println();
		double convertedAmount=0;
		switch(currency)
		{
			case 1:
				convertedAmount=amount*0.012;
				System.out.println("Amount in USD: "+convertedAmount);
				break;
			case 2:
				convertedAmount=amount*0.011;
				System.out.println("Amount in EUR: "+convertedAmount);
				break;
			case 3:
				convertedAmount=amount*0.0095;
				System.out.println("Amount in GBP: "+convertedAmount);
				break;
			case 4:
				convertedAmount=amount*1.80;
				System.out.println("Amount in JPY: "+convertedAmount);
				break;
			default:
				System.out.println("Invalid currency option!");
		}
		System.out.print("Do you want another conversion?(y/n): ");
		choice=sc.next().charAt(0);
	}while(choice=='y'||choice=='Y');
	sc.close();
	System.out.println("Thank you for using the Currency Exchange kiosk!");
	}
}