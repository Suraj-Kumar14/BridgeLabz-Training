import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// Create DateComparisons Class to comparision the dates
public class DateComparisons 
{
    public static void main(String[] args) {
	
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//Taking input from user
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");

       
        System.out.print("Enter first date (yyyy MM dd): ");
        LocalDate date1 = LocalDate.parse(sc.nextLine(), formatter);

       
        System.out.print("Enter second date (yyyy MM dd): ");
        LocalDate date2 = LocalDate.parse(sc.nextLine(), formatter);

        if (date1.isBefore(date2)) {
            System.out.println("First date is BEFORE the second date.");
        } else if (date1.isAfter(date2)) {
            System.out.println("First date is AFTER the second date.");
        } else if (date1.isEqual(date2)) {
            System.out.println("Both dates are the SAME.");
        }

      
    }
}