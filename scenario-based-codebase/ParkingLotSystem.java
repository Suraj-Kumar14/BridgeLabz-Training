import java.util.Scanner;
public class ParkingLotSystem{
	public static void main(String [] args){
	int Occupancy=10;
	int park=0;
	int truck=0;
	int bike=0;
	int car=0;
	while(true){
	System.out.println("1.For Park press 'P': ");
	System.out.println("2.For Exit press 'E': ");
	System.out.println("3.For Show Occupancy press 'O': ");
	System.out.print("Enter your choice: ");
	Scanner sc=new Scanner(System.in);
	char input=sc.next().charAt(0);
	System.out.println();
	
	switch(input){
	    //case for checking occupancy and then park the car
		case 'P' : case 'p' :
		{
			if(Occupancy>0){
		        System.out.println("(i). for Truck press 'T': ");
		        System.out.println("(ii). for Bike press 'B': ");
		        System.out.println("(iii). for Car press 'C': ");
				char choice=sc.next().charAt(0);
				if(choice=='T'||choice=='t'){
				System.out.println("|-------------------------------|");
			    System.out.println("Your Truck is Successfully parked!");
			    System.out.println("|-------------------------------|");
			    System.out.println();
			    Occupancy--;
			    park++;	
				truck++;
				}else if(choice=='B'||choice=='b'){
				System.out.println("|------------------------------|");
			    System.out.println("Your Bike is Successfully parked!");
			    System.out.println("|------------------------------|");
			    System.out.println();
			    Occupancy--;
			    park++;	
				bike++;
				}else if(choice=='C'||choice=='c'){
				System.out.println("|------------------------------|");
			    System.out.println("Your Car is Successfully parked!");
			    System.out.println("|------------------------------|");
			    System.out.println();
			    Occupancy--;
			    park++;	
				car++;
				}
         	}
			else{
			System.out.println("Sorry, Parking Lot is already full.");
			System.out.println();
			}
			break;
		}
		
		//case for Exit the car 
		case 'E' : case 'e':
		{
			if(park>0){
			    System.out.println("(i). for Truck press 'T': ");
		        System.out.println("(ii). for Bike press 'B': ");
		        System.out.println("(iii). for Car press 'C': ");
				char choice=sc.next().charAt(0);
				if(choice=='T'||choice=='t'){
					if(truck>0){
				System.out.println("|--------------------------------|");
			    System.out.println("Your Truck is Successfully Exited!");
			    System.out.println("|--------------------------------|");
			    System.out.println();
			    Occupancy++;
			    park--;	
				truck--;
					} else{
						System.out.println("Sorry,you haven't park your truck yet.");
					}
				}else if(choice=='B'||choice=='b'){
					if(bike>0){
				System.out.println("|-------------------------------|");
			    System.out.println("Your Bike is Successfully Exited!");
			    System.out.println("|-------------------------------|");
			    System.out.println();
			    Occupancy++;
			    park--;	
				bike--;
					}else{
						System.out.println("Sorry,you haven't park your Bike yet.");
						System.out.println();
					}
				}else if(choice=='C'||choice=='c'){
					if(car>0){
				System.out.println("|------------------------------|");
			    System.out.println("Your Car is Successfully Exited!");
			    System.out.println("|------------------------------|");
			    System.out.println();
			    Occupancy++;
			    park--;	
				car--;
					}else{
						System.out.println("Sorry,you haven't park your Car yet.");
						System.out.println();
					}
				}
			}
			else{
				System.out.println("Still You haven't parking your vehicles!");
				System.out.println();
			}
			break;
		}
		
		//case for show Occupancy of parking lot
		case 'O': case'o':
		{
			if(Occupancy<=10){
			System.out.println("Total vacant lot :"+Occupancy);
			System.out.println();
			}
			else{
			System.out.println("Sorry, Parking Lot is full.");
			System.out.println();
			}
			break;
		}
		
		//Default case
		default :
		{
			System.out.println("You selected the wrong choice.");
			break;
		}
	}
	}
	}
}