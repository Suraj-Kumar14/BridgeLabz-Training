import java.util.Scanner;
public class TrainReservationQueue{
	public static void main(String [] args){
	//Create Scanner object
	Scanner sc=new Scanner(System.in);
	int totalSeat=10;
	while(true){
		System.out.println();
		System.out.println("--Train Ticket Reservation Menu--");
		System.out.println("Seat Available: "+totalSeat);
		System.out.println("1.Book Ticket");
		System.out.println("2.Exit System");
		System.out.print("Select choice: ");
		int choice=sc.nextInt();
		System.out.println();
		
		switch(choice)
		{
			case 1:
			{
				if(totalSeat==0){
				System.out.println("Sorry, all seats are booked.");
				}
				System.out.print("Enter how many seats would you like to book: ");
				int number=sc.nextInt();
				if(number>totalSeat){
				System.out.println("Sorry "+number+" seat is not available!");
				}
				else{
				System.out.println("Your Seat is booked");
				totalSeat-=number;
					if(totalSeat==0){
					System.out.println("All seats are booked");
					}
				}
				break;
			}
			case 2:
			{	
				System.out.println("You Successfully exited the system.");
				sc.close();
				return;
			}
			default :
			{
				System.out.println("Wrong choice!");
			}
		}
		if(totalSeat==0){
			break;
		}
	}
	}
}