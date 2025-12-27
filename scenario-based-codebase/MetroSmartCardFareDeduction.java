import java.util.Scanner;
//Create MetroSmartCardFareDeduction Class to compute Metro Smart Card Fare Deduction
public class MetroSmartCardFareDeduction{
	
	String name;
	double balance;
		
	//constructor 
	MetroSmartCardFareDeduction(String name, double balance){
		this.name = name;
		this.balance = balance;
	}
	
	//travel amount system
	public void travelSystem(float distance){
		double amount = (distance*7);
		
		if(amount<=balance){
			this.balance-=amount;
			System.out.println("The amount " + amount + " has been deducted for travelling " + distance + " KM");
		}else{
			System.out.println("Unsufficient Balance!");
		}
	}
	
	//card balance
	public void cardBalance(){
		System.out.println("Card balance is "+ this.balance);
	}
	
	public static void main (String args[]){
		
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//Taking input as age from user
		System.out.println("Enter your name: ");
		String name = sc.nextLine();
		
		System.out.println("Enter the amount: ");
		double balance = sc.nextDouble();
		
		//creating object
		MetroSmartCardFareDeduction travel = new MetroSmartCardFareDeduction(name, balance);
		
		while(true){
			System.out.println("Enter 'E' for exit   :");
			System.out.println("Enter 'T' for travel :");
			System.out.println("Enter 'V' for balance:");
			
			//taking the input 
			char c = sc.next().charAt(0);
			
			sc.nextLine();
			
			if(c=='e' || c=='E'){
				break;
			}
			else if(c=='t' || c=='T'){
				System.out.println("Enter the distance   :");
				float distance = sc.nextFloat();
				travel.travelSystem(distance);
			}else{
				travel.cardBalance();
			}
		}
	}
}	