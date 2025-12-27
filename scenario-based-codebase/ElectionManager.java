import java.util.Scanner;
//Create ElectionManager Class to compute the condidate votes and their win
public class ElectionManager{
	public static int count =0;
	public static int bjpCandidate =0;
	public static int congressCandidate=0;
	public static int notaCandidate = 0;
	
	String name;
	int age;
	boolean voteRecord = false;
	
	//constructor
	ElectionSystem(String n, int a){
		this.name = n;
		this.age = a;
	}
	
	//check age is valid or not 
	public boolean isValid(){
		if(age>=18){
			return true;
		}else{
			return false;
		}
	}
	
	//vote system
	public void voteSystem(char c){
		if(!voteRecord && isValid()){
			if(c=='b' || c=='B'){
				this.bjpCandidate+=1;
				this.voteRecord = true;
			}
			else if(c=='c' || c=='C'){
				this.congressCandidate+=1;
				this.voteRecord = true;
			}
			else if(c=='n' || c=='N'){
				this.notaCandidate+=1;
				this.voteRecord = true;
			}
			System.out.println("Voting Successful.");
		}
		else{
			System.out.println("Not eligible for vote");
		}
	}
	
	//displaying the result
	public static void result(){
		System.out.println("The total vote of BJP is "+bjpCandidate);
		System.out.println("The total vote of Congress is "+congressCandidate);
    	System.out.println("The total vote of Nota is "+notaCandidate);
	}
	
	public static void main (String args[]){
		
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		while(true){
			//Taking input as age from user
			System.out.println("Enter your name: ");
			String name = sc.nextLine();
			
			System.out.println("Enter your age: ");
			int age = sc.nextInt();
			
			sc.nextLine();
			 
			//creating the object 
			ElectionSystem election = new ElectionSystem(name, age);
			
			System.out.println("Enter 'B' for BJP :");
			System.out.println("Enter 'C' for Congress :");
			System.out.println("Enter 'N' for Nota :");
			System.out.println("Enter 'E' for Exit :");
			
			//taking the input 
			char c = sc.next().charAt(0);
			
			sc.nextLine();
			
			if(c=='e' || c=='E'){
				break;
			}
			//calling the voteSystem for vote 
			
			election.voteSystem(c);
		}
		result();
	}
}	