import java.util.Scanner;
public class BusRouteDistanceTracker{
	public static void main(String [] args){
	Scanner sc=new Scanner(System.in);
	double totalDistance=0;
	char getOff='n';
	
	//while loop to add total distance covered by user
	while(getOff!='y'&& getOff!='Y'){
	System.out.println("----Bus Route Distance Tracker----");
	//Take distance in km from user
	System.out.print("Enter distance covered to next stop: ");
	double stopDistance=sc.nextDouble();
	//add total distance
	totalDistance+=stopDistance;
	
	//print total distance
	System.out.println("Total distance covered: "+totalDistance+"km");
	
	//Ask for get off
	System.out.print("Do you want to get off at this stop?(y/n): ");
	getOff=sc.next().charAt(0);
	}
	System.out.println("You got off the bus.");
	System.out.println("Final distance travelled: "+totalDistance+" km");
	sc.close();
	}
}
	