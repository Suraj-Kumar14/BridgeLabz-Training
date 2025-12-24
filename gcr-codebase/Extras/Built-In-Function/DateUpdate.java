import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class DateUpdate {
    public static void main(String[] args) {
		//Scanner object for taking input from user
        Scanner sc = new Scanner(System.in);

		//Taking user input date
        System.out.print("Enter date (yyyy MM dd): ");
        String input = sc.nextLine();
   
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
       
        LocalDate date = LocalDate.parse(input, formatter);

        LocalDate result = date
                .plusDays(7)
                .plusMonths(1)
                .plusYears(2)
                .minusWeeks(3);

		//Displaying the output
        System.out.println("Final Date: " + result);
    }
}