//Creating Class with name AgeOfHarry to indicating the purpose is to display The Current Year/Age of Harry
public class AgeOfHarry
{
     public static void main(String [] args)
	 { 
	     //Create two int variable harryAge, birthYear and assign the value 2000
	     int harryAge,birthYear=2000;
		 
	     //Create a int variable currentYear and assign the value 2024
	     int currentYear=2024;

	     // Calculate the age of Harry by substracting birthyear from currentyear
	      harryAge= currentYear-birthYear;
		 
	     //Displaying Current year  as output.
	     System.out.println("Harry's age in 2024 is "+harryAge);
    }
} 