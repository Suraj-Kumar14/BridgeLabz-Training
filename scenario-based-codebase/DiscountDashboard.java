import java.util.Scanner;
public class DiscountDashboard{
	public static void main(String [] args){
	//Create a scanner object
	Scanner sc=new Scanner(System.in);
    double finalAmount;
	double discountAmount;
	double totalBill=0;
	
	//Taking number of items from user
	System.out.print("Enter number of items: ");
	int number=sc.nextInt();
	
	//for loop for input item prices
	for(int i=1;i<=number;i++){
	System.out.print("Enter price of "+i+" item: ");
	double price=sc.nextDouble();
	System.out.print("Enter quantity: ");
	int quantity=sc.nextInt();
	price= price*quantity;
	totalBill+=price;
	}
	System.out.println();
	
	//Discount logic using if-else
	if(totalBill>500){
	discountAmount=totalBill*0.2;
	finalAmount=totalBill-discountAmount;
	System.out.println("|--------Bill Summary------------|");
	System.out.println("Your total bill is "+totalBill);
	System.out.println("Your Discount amount is "+discountAmount);
	System.out.println("Your final amount to pay is "+finalAmount);
	System.out.println("|--------------------------------|");
	}	
	else if(totalBill<500 && totalBill>200){
	discountAmount=totalBill*0.1;
	finalAmount=totalBill-discountAmount;
	System.out.println("|--------Bill Summary------------|");
	System.out.println("Your total bill is "+totalBill);
	System.out.println("Your Discount amount is "+discountAmount);
	System.out.println("Your final amount to pay is "+finalAmount);
	System.out.println("|--------------------------------|");
	} 
	else {
	discountAmount=totalBill*0.05;
	finalAmount=totalBill-discountAmount;
	System.out.println("|--------Bill Summary------------|");
	System.out.println("Your total bill is "+totalBill);
	System.out.println("Your Discount amount is "+discountAmount);
	System.out.println("Your final amount to pay is "+finalAmount);
	System.out.println("|--------------------------------|");
	}
	}
}