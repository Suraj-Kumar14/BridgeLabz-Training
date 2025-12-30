import java.util.Scanner;
public class FitnessChallengeTracker{
	public static void main(String[] args){
	//Create a Scanner object
	Scanner sc=new Scanner(System.in);
	//Array to store counts for a week
	int []pushUp=new int[7];
	int totalPushUp=0;
	double average;
	int workoutDays=0;
	
	//loop to count the total push-up in a week
	for(int i: pushUp){
		System.out.print("Enter "+(i+1)+" day push-up: ");
		pushUp[i]=sc.nextInt();
		if(pushUp[i]==0){
			continue;
		}
		else{
		totalPushUp+=pushUp[i];
		workoutDays++;
		}
	}
	average=totalPushUp/7.0;
	System.out.println();
	System.out.println("Total Workout days: "+workoutDays);
	System.out.println("Total push-up in a week: "+totalPushUp);
	System.out.println("Average push-up of one week: "+average);
	}
}
	