import java.util.Scanner;
//create a class SchoolBusAttendance to indicating the purpose of taking attendance in School Bus
public class SchoolBusAttendance{
		
	public static void main(String [] args){
	String []Students={"Avinash","Arvind","Suraj","rishav","Kishan","Ravi","Shivam","Gulshan","Sunny","Vikash"};
	//Create Scanner object
	Scanner sc=new Scanner(System.in);
	//Variable to count total present
	int pCount=0;
	//variable to count total absent
	int aCount=0;
	
	//for-each loop to count present and absent
	for(String name:Students){
		System.out.print("Is "+name+" present or absent? (P/A): ");
		char status=sc.next().toUpperCase().charAt(0);
		if(status=='P'){
		pCount++;
		}
		else{
		aCount++;
		}
	}
	System.out.println();
	System.out.println("Total present Student: "+pCount);
	System.out.println("Total absent student: "+aCount);
	}
}